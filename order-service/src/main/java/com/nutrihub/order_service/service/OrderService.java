package com.nutrihub.order_service.service;

import com.nutrihub.order_service.entity.OrderItems;
import com.nutrihub.order_service.entity.Orders;
import com.nutrihub.order_service.entity.dto.OrderRequestDto;
import com.nutrihub.order_service.repo.OrderItemsRepository;
import com.nutrihub.order_service.repo.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private OrdersRepository ordersRepository;

    private ModelMapper modelMapper;

    private OrderItemsRepository orderItemsRepository;


    public  String placeOrder(OrderRequestDto orderRequestDto) {
        Orders orders=modelMapper.map(orderRequestDto, Orders.class);
        orders.setPlacedAt(LocalDateTime.now());

        List<OrderItems> orderItemsList=orderRequestDto.getOrderItemsList()
                .stream()
                .map(orderItemsRequestDto -> {
                    OrderItems orderItems=modelMapper.map(orderItemsRequestDto, OrderItems.class);
                    orderItems.setOrder(orders);
                    return orderItems;
                }).toList();

        orders.setOrderItemsList(orderItemsList);

        ordersRepository.save(orders);

        return "order placed successfully";

    }

    public  String cancelOrder(OrderRequestDto orderRequestDto) {

        Optional<Orders> orders=ordersRepository.findById(orderRequestDto.getId());
        orders.get().setStatus("CANCELLED");

        ordersRepository.save(orders.get());

        return "Order cancelled";
    }
}
