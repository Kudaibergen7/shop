package com.example.ecommerce_online.service;

import com.example.ecommerce_online.model.entity.Product;
import com.example.ecommerce_online.model.request.CreateProductRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product create(CreateProductRequest request);
    Product get(Long id);

    List<Product> getProductsByCategory(Long categoryId);
    Product update(Product request);
    Product delete(Long id);

    List<Product> getAll();
}
