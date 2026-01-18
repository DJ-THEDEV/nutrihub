package com.nutrihub.onboarding_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
public class Addresses {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;


    private Long userId;

    private Long tenantId;

    private String addressType;

    private String status;

    private String line1;

    private String line2;

    private String city;

    private String state;

    private String pinCode;

    private Date createdAt;

    private Date updatedAt;

}
