package com.nutrihub.restaurant_service.entity.dto;

import lombok.Data;

@Data
public class MenuItemsRequestDto {


    private Long id;

    private Long tenantId;

    private String name;

    private String description;

    private String itemType;

    private Boolean is_veg;

    private Double price;

    private Boolean isAvailable;

}
