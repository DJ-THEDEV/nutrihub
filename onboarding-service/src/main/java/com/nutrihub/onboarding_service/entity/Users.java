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
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    private String email;

    private String password;

    private String userType;
    private String role;
    private String contactNo;
    private String status;

    private String tenantId;




    private Date createdAt;

    private Date updatedAt;

}
