package com.aaapis.kyp.models;

import com.aaapis.kyp.enums.Department;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String password;
    private String Name;
    private String email;
    private String phoneNumber;
    private Department department;
    private String role;
}
