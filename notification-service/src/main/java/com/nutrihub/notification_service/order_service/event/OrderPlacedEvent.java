package com.nutrihub.notification_service.order_service.event;

import lombok.Data;


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
