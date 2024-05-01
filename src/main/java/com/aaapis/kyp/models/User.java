package com.aaapis.kyp.models;

import com.aaapis.kyp.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private String token;
    private UserRole role;
}