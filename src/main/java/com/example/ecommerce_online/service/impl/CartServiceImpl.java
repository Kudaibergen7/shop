package com.example.ecommerce_online.service.impl;

import com.example.ecommerce_online.model.entity.Cart;
import com.example.ecommerce_online.model.request.ProductCartRequest;
import com.example.ecommerce_online.repository.CartRepository;
import com.example.ecommerce_online.repository.ProductRepository;
import com.example.ecommerce_online.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @Override
    public Cart get(Long id) {
        return cartRepository.getById(id);
    }

    @Override
    public Cart add(ProductCartRequest request) {
        Cart cart = cartRepository.findById(request.getCartId()).orElse(new Cart());
        cart.getProducts().add(productRepository.getProductById(request.getProductId()));
        return cartRepository.save(cart);
    }

    @Override
    public Cart remove(ProductCartRequest request) {
        Cart cart = cartRepository.findById(request.getCartId()).orElseThrow(RuntimeException::new);
        cart.getProducts().remove(productRepository.getProductById(request.getProductId()));
        return cartRepository.save(cart);
    }
}
