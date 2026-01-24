package com.nutrihub.order_service.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
public class Orders {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long userId;

    private Long tenantId;

    private String status;

    private String deliveryAddress;

    private String totalAmount;

    private String paymentStatus;

  private LocalDateTime placedAt;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderItems> orderItemsList;

    @OneToOne(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
    private PaymentInformation paymentInformation;
}
