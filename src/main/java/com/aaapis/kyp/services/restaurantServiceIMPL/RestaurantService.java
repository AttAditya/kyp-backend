package com.aaapis.kyp.services.restaurantServiceIMPL;

import com.aaapis.kyp.models.Restaurant;
import com.aaapis.kyp.models.Table;
import com.aaapis.kyp.services.IRestaurantService;
import org.springframework.stereotype.Service;
import com.aaapis.kyp.repositories.RestaurantRepository;


import java.util.List;
import java.util.Optional;

@Service("V1RestaurantService")
public class RestaurantService implements IRestaurantService {
    private RestaurantRepository restaurantRepository;
    private TableRepository tableRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> getRestaurantsByName(String restaurantName) {
        Optional<List<Restaurant>> optionalRestaurant = Optional.ofNullable(restaurantRepository.findByName(restaurantName));
        if(optionalRestaurant.isEmpty()) {
            throw new restaurantNotFoundException(restaurantName, "Please pass a valid restaurantName");
        }
        return optionalRestaurant.get();
    }

    @Override
    public Restaurant getRestaurantById(Long restaurantId) {
        Optional<Restaurant> optionLProduct = restaurantRepository.findById(restaurantId);
        if (optionLProduct.isEmpty()) {
            throw new restaurantNotFoundException(restaurantId, "Please pass a valid restaurantId");
        }
        return optionLProduct.get();
    }

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        List<Table> tables = restaurant.getTables();

        for (Table table : tables) {
            if (table.getId() == null) {
                tableRepository.save(table);
            }
        }




    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        return null;
    }

    @Override
    public Restaurant deleteRestaurant(Long restaurantId) {
        return null;
    }
}
