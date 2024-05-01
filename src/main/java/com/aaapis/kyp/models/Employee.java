package com.aaapis.kyp.models;

import com.aaapis.kyp.enums.Department;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "Employee")
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
