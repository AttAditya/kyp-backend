package com.aaapis.kyp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity(name = "Table")
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long tableNumber;
    private int capacity;
    @OneToMany(fetch = FetchType.LAZY)
    List<Reservation> reservations;
    @OneToOne
    private Location location;
}
