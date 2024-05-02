package com.aaapis.kyp.services;

import com.aaapis.kyp.dtos.AddTableDTO;
import com.aaapis.kyp.dtos.RestaurantRequestDTO;
import com.aaapis.kyp.models.Restaurant;

import java.util.List;

public interface IRestaurantService {
    List<Restaurant> getRestaurantsByName(String restaurantName);
    Restaurant getRestaurantById(Long restaurantId);
    Restaurant createRestaurant(RestaurantRequestDTO restaurantRequestDTO);
    Restaurant updateRestaurant(RestaurantRequestDTO restaurantRequestDTO);
    void deleteRestaurant(Long restaurantId);
    Restaurant addTable(Long restaurantId, AddTableDTO addTableDTO);
}
