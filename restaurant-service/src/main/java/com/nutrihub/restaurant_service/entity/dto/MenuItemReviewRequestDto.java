package com.nutrihub.restaurant_service.entity.dto;

import lombok.Data;

@Data
public class MenuItemReviewRequestDto {


    private Long menuItemId;

    private Long userId;

    private Double rating;

    private String comments;

}
