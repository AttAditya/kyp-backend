package com.aaapis.kyp.controllers;

import com.aaapis.kyp.dtos.UserDTOs;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthControllers {

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody UserDTOs request) {
        // Implement user login logic here
        System.out.println(request.getName() + " got this from user");
        return ResponseEntity.ok().build();
    }


}
