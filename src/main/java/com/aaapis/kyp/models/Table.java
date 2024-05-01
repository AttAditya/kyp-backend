package com.aaapis.kyp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity(name = "SittingTable")
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int tableNumber;
//    private int capacity;
//    @OneToMany(fetch = FetchType.LAZY)
//    private List<Reservation> reservations;
//    @OneToOne
//    private Location location;
    private boolean isAvailable;
}
