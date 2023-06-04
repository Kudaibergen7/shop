package com.example.ecommerce_online.service;

import com.example.ecommerce_online.model.entity.Category;
import com.example.ecommerce_online.model.request.CreateCategoryRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    Category create(CreateCategoryRequest request);

    List<Category> getAll();

    Category get(Long id);

    Category update(Category category);

    Category delete(Long id);

}
