package com.aaapis.kyp.models;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(stratergy = GenerationType.IDENTITY)
    private Long id;
    private Date startTime;
    private Date endTime;
    @ManyToMany
    private List<Customer> guests;
    private Customer billing_customer;
    private Employee employee;
    private Table table;

}
