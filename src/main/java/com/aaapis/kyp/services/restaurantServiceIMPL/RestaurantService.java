package com.aaapis.kyp.services.restaurantServiceIMPL;

import com.aaapis.kyp.dtos.AddTableDTO;
import com.aaapis.kyp.dtos.RestaurantRequestDTO;
import com.aaapis.kyp.exceptions.RestaurantNotFoundException;
import com.aaapis.kyp.exceptions.TableAlreadyExistsException;
import com.aaapis.kyp.exceptions.TableNotFoundException;
import com.aaapis.kyp.models.Restaurant;
import com.aaapis.kyp.models.Table;
import com.aaapis.kyp.repositories.TableRepository;
import com.aaapis.kyp.services.IRestaurantService;
import org.springframework.stereotype.Service;
import com.aaapis.kyp.repositories.RestaurantRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("V1RestaurantService")
public class RestaurantService implements IRestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final TableRepository tableRepository;

    public RestaurantService(RestaurantRepository restaurantRepository,TableRepository tableRepository) {
        this.restaurantRepository = restaurantRepository;
        this.tableRepository = tableRepository;
    }

    @Override
    public List<Restaurant> getRestaurantsByName(String restaurantName) {
        Optional<List<Restaurant>> optionalRestaurant = Optional.ofNullable(restaurantRepository.findByName(restaurantName));
        if(optionalRestaurant.isEmpty()) {
            throw new RestaurantNotFoundException(restaurantName+ " not found. Please pass a valid restaurant Name");
        }
        return optionalRestaurant.get();
    }

    @Override
    public Restaurant getRestaurantById(Long restaurantId) {
        Optional<Restaurant> optionLProduct = restaurantRepository.findById(restaurantId);
        if (optionLProduct.isEmpty()) {
            throw new RestaurantNotFoundException("Restaurant not found. Please pass a valid restaurantId");
        }
        return optionLProduct.get();
    }

    @Override
    public Restaurant createRestaurant(RestaurantRequestDTO restaurantRequestDTO) {
        Restaurant restaurant = new Restaurant();

        List<Table> tables = new ArrayList<>();

        restaurant.setDescription(restaurantRequestDTO.getDescription());
        restaurant.setTables(tables);
        restaurant.setName(restaurantRequestDTO.getName());

        return restaurantRepository.save(restaurant);
    }


    @Override
    public Restaurant updateRestaurant(RestaurantRequestDTO restaurantRequestDTO) {
        return null;
    }

    @Override
    public void deleteRestaurant(Long restaurantId) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(restaurantId);
        if(optionalRestaurant.isEmpty()) {
            throw new RestaurantNotFoundException("Restaurant not found. Please pass a valid restaurantId");
        }
        restaurantRepository.deleteById(restaurantId);
    }

    @Override
    public Restaurant addTable(Long restaurantId, AddTableDTO addTableDTO) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(restaurantId);

        if(optionalRestaurant.isEmpty()) {
            throw new RestaurantNotFoundException("Restaurant not found: " + restaurantId);
        }

        Optional<Table> optionalTable = tableRepository.findById(addTableDTO.getTableId());

        if(optionalTable.isEmpty()) {
            throw new TableNotFoundException("Table not found: " + addTableDTO.getTableId());
        }

        Restaurant restaurant = optionalRestaurant.get();
        Table table = optionalTable.get();

        for (Table existingTable : restaurant.getTables()) {
            if (existingTable.getId().equals(table.getId())) {
                throw new TableAlreadyExistsException("Table already exists: " + existingTable.getId());
            }
        }

        restaurant.getTables().add(table);
        return restaurantRepository.save(restaurant);
    }
}
