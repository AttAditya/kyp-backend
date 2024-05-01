package com.aaapis.kyp.controllers;

import com.aaapis.kyp.dtos.RestaurantRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    // User Actions Endpoints
    @GetMapping("/{name}")
    public ResponseEntity<?> searchRestaurants(@PathVariable String name) {
        // Implement user login logic here
        System.out.println(name + "got this from user");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRestaurantById(@PathVariable Long id) {
        // Implement user login logic here
        System.out.println(id + " got this from user as restaurant id");
        return ResponseEntity.ok().build();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createRestaurant(@RequestBody RestaurantRequestDTO request) {
        // Implement user login logic here
        System.out.println(request.getName() + " got this from user");
        return ResponseEntity.ok().build();
    }



}
