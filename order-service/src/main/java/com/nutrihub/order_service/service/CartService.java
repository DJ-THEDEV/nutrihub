package com.nutrihub.order_service.service;

import com.nutrihub.order_service.entity.CartItems;
import com.nutrihub.order_service.entity.Carts;
import com.nutrihub.order_service.entity.dto.CartItemsRequestDto;
import com.nutrihub.order_service.entity.dto.CartRequestDto;
import com.nutrihub.order_service.repo.CartItemsRepository;
import com.nutrihub.order_service.repo.CartsRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartItemsRepository cartItemsRepository;

    private final CartsRepository cartsRepository;

    private final ModelMapper modelMapper;

    public  String addOrUpdateItemToCart(CartRequestDto cartRequestDto) {
      saveCart(cartRequestDto);
        return "added to cart";
    }

    private void saveCart(CartRequestDto cartRequestDto) {
    Carts cart= modelMapper.map(cartRequestDto,Carts.class);

        List<CartItems> cartItemsList = cartRequestDto.getCartItemsList()
                .stream()
                .map(cartItemsRequestDto -> {
                    CartItems cartItems=modelMapper.map(cartItemsRequestDto,CartItems.class);
                    cartItems.setCart(cart);
                    return cartItems;
                }).toList();

        cart.setCartItemsList(cartItemsList);

        cartsRepository.save(cart);
    }
}
