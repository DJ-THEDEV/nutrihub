package com.nutrihub.order_service.entity.dto;

import lombok.Data;

@Data
public class OrderItemsRequestDto {
    private Long menuItemId;

    private Long quantity;

    private Double price;

}
