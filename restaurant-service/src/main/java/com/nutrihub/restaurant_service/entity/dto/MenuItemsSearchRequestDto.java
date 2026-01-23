package com.nutrihub.restaurant_service.entity.dto;

import lombok.Data;

@Data
public class MenuItemsSearchRequestDto {

    private String name;

    private String description;

    private String itemType;

    private Boolean isVeg;

    private Double price;

    private Double rating;


    private String sortBy;

    private String sortOrder;

    private int page;

    private int pageSize;
}
