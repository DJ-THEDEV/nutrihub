package com.nutrihub.order_service.repo;

import com.nutrihub.order_service.entity.Carts;
import com.nutrihub.order_service.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartsRepository extends JpaRepository<Carts,Long> {
}
