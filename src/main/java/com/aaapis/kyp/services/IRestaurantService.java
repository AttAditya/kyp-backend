package com.aaapis.kyp.services;

import com.aaapis.kyp.models.Restaurant;

import java.util.List;

public interface IRestaurantService {
    List<Restaurant> getRestaurantsByName(String restaurantName);
    Restaurant getRestaurantById(Long restaurantId);
    Restaurant createRestaurant(Restaurant restaurant);
    Restaurant updateRestaurant(Restaurant restaurant);
    Restaurant deleteRestaurant(Long restaurantId);
}
