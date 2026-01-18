package com.nutrihub.onboarding_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class TenantDocuments {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    private String docType;

    private Long tenantId;

    private String docPath;

    private String verificationStatus;


}
