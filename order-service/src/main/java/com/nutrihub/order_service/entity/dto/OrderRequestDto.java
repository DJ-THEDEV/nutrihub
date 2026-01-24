package com.nutrihub.order_service.entity.dto;

import com.nutrihub.order_service.entity.OrderItems;
import com.nutrihub.order_service.entity.PaymentInformation;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderRequestDto {

    private Long userId;

    private Long tenantId;

    private String status;

    private String deliveryAddress;

    private String totalAmount;

    private String paymentStatus;

    private List<OrderItemsRequestDto> orderItemsList;



}
