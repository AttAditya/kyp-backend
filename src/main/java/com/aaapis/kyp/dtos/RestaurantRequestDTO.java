package com.aaapis.kyp.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantRequestDTO {
    private String name;
    private String description;
    private String address;
    private String phone;
    private String email;
    private String imageUrl;
    private String menuUrl;
    private String websiteUrl;
    private String status;
    private String createdBy;
    private int tableCount;
}
