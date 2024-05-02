package com.aaapis.kyp.models;

import com.aaapis.kyp.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private String token;
    private UserRole role;

    @ManyToMany
    List<Reservation> history;

}