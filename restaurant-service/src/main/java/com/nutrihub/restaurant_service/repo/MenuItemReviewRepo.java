package com.nutrihub.restaurant_service.repo;

import com.nutrihub.restaurant_service.entity.MenuItemReview;
import com.nutrihub.restaurant_service.entity.MenuItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemReviewRepo extends JpaRepository<MenuItemReview,Long> {
}
