package com.nutrihub.onboarding_service.repository;

import com.nutrihub.onboarding_service.entity.TenantDocuments;
import com.nutrihub.onboarding_service.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo  extends JpaRepository<Users,Long> {
}
