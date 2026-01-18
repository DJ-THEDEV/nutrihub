package com.nutrihub.onboarding_service.repository;

import com.nutrihub.onboarding_service.entity.Addresses;
import com.nutrihub.onboarding_service.entity.TenantDocuments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressesRepo  extends JpaRepository<Addresses,Long> {
}
