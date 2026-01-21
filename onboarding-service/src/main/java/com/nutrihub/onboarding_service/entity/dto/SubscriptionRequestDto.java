package com.nutrihub.onboarding_service.entity.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SubscriptionRequestDto {
    private String plan;

    private String status;

    private Date validFrom;

    private Date validTill;


}
