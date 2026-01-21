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
public class Addresses {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

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
