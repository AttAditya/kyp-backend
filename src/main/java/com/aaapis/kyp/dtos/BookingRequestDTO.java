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
    private Date startTime;
    private Date finishTime;
    private Integer numberOfPeople;
    private Long tableId;
}
