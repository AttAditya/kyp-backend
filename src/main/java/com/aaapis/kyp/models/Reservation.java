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
    private Date finishTime;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToOne
    private User user;

    @ManyToOne
    private Table table;

}
