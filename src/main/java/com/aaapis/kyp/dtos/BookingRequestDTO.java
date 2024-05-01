package com.aaapis.kyp.dtos;

import com.aaapis.kyp.models.Table;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequestDTO {
    private Long userId;
    private Long restaurantId;
    private Date bookingDate;
    private String bookingTime;
    private Integer numberOfPeople;
    private List<Long> tableIds;
//    private String specialRequest;


}
