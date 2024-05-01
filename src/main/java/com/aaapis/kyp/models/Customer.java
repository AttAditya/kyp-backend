package com.aaapis.kyp.models;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    String password;
    String Name;
    String email;
    String role;
    @ManyToMany(fetch = FetchType.LAZY)
    List<Reservation> reservationHistory;
}
