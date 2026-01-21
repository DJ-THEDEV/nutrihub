package com.nutrihub.onboarding_service.entity.dto;

import lombok.Data;



@Data
public class UsersRequestDto {


    private String email;
    private String password;
    private String userType;
    private String contactNo;
    private String tenantId;
    private String role;

}
