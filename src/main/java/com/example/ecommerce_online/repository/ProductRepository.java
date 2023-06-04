package com.example.ecommerce_online.repository;

import com.example.ecommerce_online.model.entity.Category;
import com.example.ecommerce_online.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product getProductById(Long id);

    List<Product> getProductsByCategory(Category category);
}
