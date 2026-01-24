package com.nutrihub.order_service.repo;

import com.nutrihub.order_service.entity.CartItems;
import com.nutrihub.order_service.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems,Long> {
}
