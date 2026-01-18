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
public class Subscriptions {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    private Long tenantId;

    private String plan;

    private String status;

    private Date validFrom;

    private Date validTill;

    private Date createdAt;

}
