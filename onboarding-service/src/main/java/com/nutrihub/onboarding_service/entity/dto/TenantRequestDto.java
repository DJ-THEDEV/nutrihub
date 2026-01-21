package com.nutrihub.onboarding_service.entity.dto;

import com.nutrihub.onboarding_service.entity.Subscriptions;
import com.nutrihub.onboarding_service.entity.TenantDocuments;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TenantRequestDto {

    private String adminEmailId;


    private String name;

    private String status;

    private String businessType;

    private List<TenantDocumentRequestDto> documents;

    private SubscriptionRequestDto subscription;
}
