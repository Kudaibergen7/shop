package com.example.ecommerce_online.service.impl;

import com.example.ecommerce_online.model.entity.Product;
import com.example.ecommerce_online.model.request.CreateProductRequest;
import com.example.ecommerce_online.repository.CategoryRepository;
import com.example.ecommerce_online.repository.ProductRepository;
import com.example.ecommerce_online.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public Product create(CreateProductRequest request) {
        return productRepository.save(Product.builder()
                        .name(request.getName())
                        .description(request.getDescription())
                        .image(request.getImage())
                        .price(request.getPrice())
                        .discount(request.getDiscount())
                        .category(categoryRepository.getCategoryById(request.getCategory()))
                        .productStatus(request.getProductStatus())
                        .discountedPrice(request.getDiscount() != null ?
                                request.getPrice().add(request.getPrice().multiply(request.getDiscount().divide( BigDecimal.valueOf(100)))) :
                                null)
                .build());
    }

    @Override
    public Product get(Long id) {
        return productRepository.getProductById(id);
    }

    @Override
    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.getProductsByCategory(categoryRepository.getCategoryById(categoryId));
    }

    @Override
    public Product update(Product request) {
        return productRepository.save(request);
    }

    @Override
    public Product delete(Long id) {
        Product product = productRepository.getProductById(id);
        productRepository.delete(product);
        return product;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
