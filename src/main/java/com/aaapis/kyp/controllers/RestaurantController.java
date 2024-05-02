package com.aaapis.kyp.controllers;

import com.aaapis.kyp.dtos.AddTableDTO;
import com.aaapis.kyp.dtos.RestaurantRequestDTO;
import com.aaapis.kyp.services.IRestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final IRestaurantService restaurantService;

    public RestaurantController(IRestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    // User Actions Endpoints
    @GetMapping("/search/{name}")
    public ResponseEntity<?> searchRestaurants(@PathVariable String name) {
        // Implement user login logic here
        System.out.println(name + "got this from user");
        return ResponseEntity.ok(restaurantService.getRestaurantsByName(name));
    }

    // Admin Actions Endpoints
    @GetMapping("/{id}")
    public ResponseEntity<?> getRestaurantById(@PathVariable Long id) {
        // Implement user login logic here
        System.out.println(id + " got this from user as restaurant id");
        return ResponseEntity.ok(restaurantService.getRestaurantById(id));
    }

    @PostMapping
    public ResponseEntity<?> createRestaurant(@RequestBody RestaurantRequestDTO request) {
        // Implement user login logic here

        System.out.println(request.getName()  + " got this from user");

        return ResponseEntity.ok(restaurantService.createRestaurant(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRestaurant(@PathVariable Long id, @RequestBody RestaurantRequestDTO request) {
        // Implement user login logic here
        System.out.println(id + " got this from user as restaurant id");
        System.out.println(request.getName() + " got this from user");
        return ResponseEntity.ok(restaurantService.updateRestaurant(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRestaurant(@PathVariable Long id) {
        // Implement user login logic here
        System.out.println(id + " got this from user as restaurant id");
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{restaurantId}/table")
    public ResponseEntity<?> createTable(@PathVariable("restaurantId") Long restaurantId, @RequestBody AddTableDTO request) {
        System.out.println("Received add table request: " + request);
        return ResponseEntity.ok(restaurantService.addTable(restaurantId, request));
    }
}
