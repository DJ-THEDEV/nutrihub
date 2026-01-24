package com.nutrihub.order_service.controller;

import com.nutrihub.order_service.entity.dto.CartRequestDto;
import com.nutrihub.order_service.entity.dto.OrderRequestDto;
import com.nutrihub.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequestDto orderRequestDto){
        return ResponseEntity.ok(orderService.placeOrder(orderRequestDto));
    }

    @PostMapping("/cancel")
    public ResponseEntity<String> cancelOrder(@RequestBody OrderRequestDto orderRequestDto){
        return ResponseEntity.ok(orderService.cancelOrder(orderRequestDto));
    }


}
