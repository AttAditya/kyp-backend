package com.aaapis.kyp.models;

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
}