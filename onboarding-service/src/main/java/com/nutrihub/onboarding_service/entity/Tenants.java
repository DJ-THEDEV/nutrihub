package com.nutrihub.onboarding_service.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
public class Tenants {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    private String name;

    private String status;

    private String businessType;

    private Date createdAt;

    private Date updatedAt;
}
