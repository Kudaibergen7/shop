package com.example.ecommerce_online.service.impl;

import com.example.ecommerce_online.model.entity.Cart;
import com.example.ecommerce_online.model.entity.Order;
import com.example.ecommerce_online.model.request.CreateOrderRequest;
import com.example.ecommerce_online.repository.CartRepository;
import com.example.ecommerce_online.repository.OrderRepository;
import com.example.ecommerce_online.repository.UserRepository;
import com.example.ecommerce_online.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @Override
    public Order create(CreateOrderRequest request) {
        Cart cart = cartRepository.getById(request.getCart());
        return orderRepository.save(Order.builder()
                        .user(userRepository.getById(request.getUser()))
                        .cart(cart)
                        .totalPrice(BigDecimal.valueOf(cart.getProducts().stream().mapToDouble(product ->
                                (product.getDiscountedPrice() != null) ?
                                    product.getDiscountedPrice().doubleValue() :
                                    product.getPrice().doubleValue()).sum()))
                .build());
    }

    @Override
    public Order get(Long id) {
        return orderRepository.getOrderById(id);
    }
}
