package com.nutrihub.order_service.service;

import com.nutrihub.order_service.entity.OrderItems;
import com.nutrihub.order_service.entity.Orders;
import com.nutrihub.order_service.entity.dto.OrderRequestDto;
import com.nutrihub.order_service.event.OrderPlacedEvent;
import com.nutrihub.order_service.repo.OrderItemsRepository;
import com.nutrihub.order_service.repo.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrdersRepository ordersRepository;

    private final ModelMapper modelMapper;

    private final OrderItemsRepository orderItemsRepository;

    private final KafkaTemplate<String,String> kafkaTemplate;
    private final KafkaTemplate<Long,OrderPlacedEvent> kafkaTemplateOrder;



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

        kafkaTemplate.send("order-placed-topic","your order has been placed");

        OrderPlacedEvent orderPlacedEvent=modelMapper.map(orders,OrderPlacedEvent.class);
        kafkaTemplateOrder.send("order-placed-data-topic",orderPlacedEvent.getId(),orderPlacedEvent);

        return "order placed successfully";

    }

    public  String cancelOrder(OrderRequestDto orderRequestDto) {

        Optional<Orders> orders=ordersRepository.findById(orderRequestDto.getId());
        orders.get().setStatus("CANCELLED");

        ordersRepository.save(orders.get());

        return "Order cancelled";
    }
}
