package com.nutrihub.restaurant_service.entity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MenuItemsSearchResponseDto {

    private Long id;

    private String name;

    private String description;

    private String itemType;

    private Boolean isVeg;

    private Double price;

    private Double rating;

}
