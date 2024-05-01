package com.aaapis.kyp.models;

import com.aaapis.kyp.enums.Department;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String userId;
    String password;
    String Name;
    String email;
    String phoneNumber;
    Department department;
    String role;
}
