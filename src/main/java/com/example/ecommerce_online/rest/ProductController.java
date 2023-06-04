package com.example.ecommerce_online.rest;

import com.example.ecommerce_online.model.entity.Category;
import com.example.ecommerce_online.model.entity.Product;
import com.example.ecommerce_online.model.request.CreateProductRequest;
import com.example.ecommerce_online.service.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@SecurityRequirement(name = "shop")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateProductRequest request) {
            return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
            return ResponseEntity.status(HttpStatus.OK).body(productService.get(id));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Product product) {
            return ResponseEntity.status(HttpStatus.OK).body(productService.update(product));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
            return ResponseEntity.status(HttpStatus.OK).body(productService.delete(id));
    }
}
