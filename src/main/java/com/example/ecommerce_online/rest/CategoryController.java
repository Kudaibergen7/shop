package com.example.ecommerce_online.rest;

import com.example.ecommerce_online.model.entity.Category;
import com.example.ecommerce_online.model.request.CreateCategoryRequest;
import com.example.ecommerce_online.service.CategoryService;
import com.example.ecommerce_online.service.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@SecurityRequirement(name = "shop")
public class CategoryController {

    private final CategoryService categoryService;
    private final ProductService productService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateCategoryRequest request) {
            return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.create(request));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
            return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAll());
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<?> getByProducts(@PathVariable Long id) {
            return ResponseEntity.status(HttpStatus.OK).body(productService.getProductsByCategory(id));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Category category) {
            return ResponseEntity.status(HttpStatus.OK).body(categoryService.update(category));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
            return ResponseEntity.status(HttpStatus.OK).body(categoryService.delete(id));
    }
}
