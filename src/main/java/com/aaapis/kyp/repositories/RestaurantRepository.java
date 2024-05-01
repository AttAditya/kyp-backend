package com.aaapis.kyp.repositories;

import com.aaapis.kyp.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findById(Long restaurantId);
    List<Restaurant> findByName(String name);
}
