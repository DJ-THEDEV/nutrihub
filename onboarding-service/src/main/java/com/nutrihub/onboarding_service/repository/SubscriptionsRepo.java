package com.nutrihub.onboarding_service.repository;

import com.nutrihub.onboarding_service.entity.Subscriptions;
import com.nutrihub.onboarding_service.entity.TenantDocuments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionsRepo  extends JpaRepository<Subscriptions,Long> {
}
