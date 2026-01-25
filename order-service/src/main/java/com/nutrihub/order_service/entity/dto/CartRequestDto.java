package com.nutrihub.order_service.entity.dto;

import com.nutrihub.order_service.entity.CartItems;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CartRequestDto {

    private Long id;

    private Long userId;

    private Long tenantId;

    private List<CartItemsRequestDto> cartItemsList;
}
