package com.aaapis.kyp.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantResponseDTO {
    private Long id;
    private String name;
    private String description;
    private String address;
    private String phone;
    private String email;
    private int rating;
    private int tableCount;
    private String imageUrl;
    private String menuUrl;
    private String websiteUrl;
    private String status;
    private String createdBy;
}
