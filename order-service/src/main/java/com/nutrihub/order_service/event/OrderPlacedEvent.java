package com.nutrihub.order_service.event;

import com.nutrihub.order_service.entity.dto.OrderItemsRequestDto;
import lombok.Data;

import java.util.List;

@Data
public class OrderPlacedEvent {

    private Long id;

    private Long userId;

    private Long tenantId;

    private String status;

    private String deliveryAddress;

    private String totalAmount;

    private String paymentStatus;

}
