package com.nutrihub.restaurant_service.repo;

import com.nutrihub.restaurant_service.entity.MenuItems;
import com.nutrihub.restaurant_service.entity.TenantReviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantReviewsRepo extends JpaRepository<TenantReviews,Long> {
}
