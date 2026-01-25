package com.nutrihub.order_service.entity.dto;

import lombok.Data;

@Data
public class CartItemsRequestDto {

    private Long id;

    private Long itemId;

    private Long quantity;
}
