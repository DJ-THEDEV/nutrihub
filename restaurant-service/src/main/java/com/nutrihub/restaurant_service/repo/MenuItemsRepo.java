package com.nutrihub.restaurant_service.repo;

import com.nutrihub.restaurant_service.entity.MenuItems;
import com.nutrihub.restaurant_service.entity.dto.MenuItemsSearchResponseDto;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface MenuItemsRepo extends JpaRepository<MenuItems,Long>, JpaSpecificationExecutor<MenuItems> {
}
