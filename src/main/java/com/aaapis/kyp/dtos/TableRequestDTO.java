package com.aaapis.kyp.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableRequestDTO {
    private Long id;
    private int tableNumber;
    private int capacity;
}
