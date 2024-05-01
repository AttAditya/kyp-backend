package com.aaapis.kyp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequestDTO {

    private Long userId;
    private Long restaurantId;
    private List<Long> tableIds;
    private String reservationDate;
    private String reservationTime;
    private int numberOfPeople;


}
