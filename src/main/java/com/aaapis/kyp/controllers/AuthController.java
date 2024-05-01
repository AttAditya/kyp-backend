package com.aaapis.kyp.controllers;

import com.aaapis.kyp.dtos.UserDTOs;
import com.aaapis.kyp.utils.JwtUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody UserDTOs request) {
        // Implement user login logic here

        String token = JwtUtils.generateToken(request.getName());
        System.out.println(token);

        System.out.println(request.getName() + " got this from user");
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<?> userRegister(@RequestBody UserDTOs request) {
        // Implement user login logic here
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName();
        System.out.println(request.getName() + " got this from user in request");
        return ResponseEntity.ok("test");
    }

    @PostMapping("/logout")
    public ResponseEntity<?> userLogout(@RequestBody UserDTOs request) {
        // Implement user login logic here
        System.out.println(request.getName() + " got this from user");
        return ResponseEntity.ok().build();
    }


}
