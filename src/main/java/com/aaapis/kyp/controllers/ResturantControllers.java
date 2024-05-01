package com.aaapis.kyp.controllers;

import com.aaapis.kyp.dtos.UserDTOs;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants")
public class ResturantControllers {

    @GetMapping("/{name}")

    public ResponseEntity<?> getRestaurants(@PathVariable String name) {
        // Implement user login logic here
        System.out.println(name + "got this from user");
        return ResponseEntity.ok().build();
    }

}
