package com.aaapis.kyp.services.restaurantServiceIMPL;

import com.aaapis.kyp.models.Restaurant;
import com.aaapis.kyp.services.IRestaurantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("V1RestaurantService")
public class RestaurantService implements IRestaurantService {
    @Override
    public List<Restaurant> getRestaurantsByName(String restaurantName) {
        return List.of();
    }

    @Override
    public Restaurant getRestaurantById(Long restaurantId) {
        return null;
    }

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        return null;
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
