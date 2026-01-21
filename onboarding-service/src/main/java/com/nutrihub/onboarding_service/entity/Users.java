package com.nutrihub.onboarding_service.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

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

    // 🔹 OPTIONAL tenant mapping
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id")
    private Tenants tenant;


    // 🔹 Tenant → Documents (OWNERSHIP)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Addresses> documents ;




    private Date createdAt;

    private Date updatedAt;

}
