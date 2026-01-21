package com.nutrihub.onboarding_service.entity.dto;

import lombok.Data;

@Data
public class TenantDocumentRequestDto {

    private String docType;

    private String docPath;

    private String verificationStatus;

}
