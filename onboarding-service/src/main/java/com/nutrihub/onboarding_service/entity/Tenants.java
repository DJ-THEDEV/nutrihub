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
public class Tenants {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    private String name;

    private String status;

    private String businessType;

    private Date createdAt;

    private Date updatedAt;

    // 🔹 Tenant → Documents (OWNERSHIP)
    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TenantDocuments> documents;

    // 🔹 Tenant → Subscriptions (OWNERSHIP)
    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    private Subscriptions subscriptions;
}
