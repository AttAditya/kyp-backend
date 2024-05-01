package com.aaapis.kyp.models;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date startTime;
    private Date endTime;
    @ManyToMany
    private List<Customer> guests;
    @ManyToOne
    private Customer billing_customer;
    @ManyToOne
    private Employee table_assistant;
    @ManyToOne
    private Table table;
}
