package com.aaapis.kyp.controllers;

import com.aaapis.kyp.dtos.AuthResponseDTO;
import com.aaapis.kyp.dtos.UserDTOs;
import com.aaapis.kyp.models.User;
import com.aaapis.kyp.services.authServiceIMPL.AuthService;
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

    AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody UserDTOs request) {
        // Implement user login logic here

        System.out.println(request.getPassword() + " got this from user");
        User user =  authService.userLogin(request.getUsername(), request.getPassword());
        String token = JwtUtils.generateToken(user.getUsername());

        return ResponseEntity.ok(new AuthResponseDTO(token, user));
    }

    @PostMapping("/register")
    public ResponseEntity<?> userRegister(@RequestBody UserDTOs request) {
        // Implement user login logic here
        User user = authService.userRegister(request);
        String token = JwtUtils.generateToken(user.getUsername());


        return ResponseEntity.ok(new AuthResponseDTO(token, user));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> userLogout(@RequestBody UserDTOs request) {
        // Implement user login logic here
        System.out.println(request.getName() + " got this from user");
        return ResponseEntity.ok().build();
    }


}
