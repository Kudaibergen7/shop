package com.example.ecommerce_online.service.impl;

import com.example.ecommerce_online.model.entity.Category;
import com.example.ecommerce_online.model.request.CreateCategoryRequest;
import com.example.ecommerce_online.repository.CategoryRepository;
import com.example.ecommerce_online.service.CategoryService;
import com.example.ecommerce_online.service.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@CacheConfig(cacheNames = {"category"})
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Category create(CreateCategoryRequest request) {
        return categoryRepository.save(Category.builder()
                        .name(request.getName())
                        .description(request.getDescription())
                        .image(request.getImage())
                .build());
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category get(Long id) {
        return categoryRepository.getCategoryById(id);
    }

    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category delete(Long id) {
        categoryRepository.deleteById(id);
        return categoryRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Could not found with id: " + id));
    }
}
