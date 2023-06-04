package com.example.ecommerce_online.service;

import com.example.ecommerce_online.model.entity.Cart;
import com.example.ecommerce_online.model.request.ProductCartRequest;

public interface CartService {

    Cart get(Long id);

    Cart add(ProductCartRequest request);

    Cart remove(ProductCartRequest request);

}
