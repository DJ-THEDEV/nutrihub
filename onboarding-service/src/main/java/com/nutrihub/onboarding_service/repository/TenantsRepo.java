package com.nutrihub.onboarding_service.repository;

import com.nutrihub.onboarding_service.entity.TenantDocuments;
import com.nutrihub.onboarding_service.entity.Tenants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantsRepo  extends JpaRepository<Tenants,Long> {
}
