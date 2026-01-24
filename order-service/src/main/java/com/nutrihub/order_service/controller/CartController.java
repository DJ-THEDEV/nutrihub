package com.nutrihub.order_service.controller;

import com.nutrihub.order_service.entity.dto.CartRequestDto;
import com.nutrihub.order_service.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<String> addOrUpdateItemsToCart(@RequestBody CartRequestDto cartRequestDto){
        return ResponseEntity.ok(cartService.addOrUpdateItemToCart(cartRequestDto));
    }



}
