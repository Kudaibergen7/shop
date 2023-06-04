package com.example.ecommerce_online.rest;

import com.example.ecommerce_online.model.request.ProductCartRequest;
import com.example.ecommerce_online.service.CartService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart")
@SecurityRequirement(name = "shop")
public class CartController {

    private final CartService cartService;

    @PreAuthorize("hasAuthority('CLIENT')")
    @GetMapping("/")
    public ResponseEntity<?> get(@RequestParam Long id) {
        return ResponseEntity.ok(cartService.get(id));
    }

    @PreAuthorize("hasAuthority('CLIENT')")
    @PutMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody ProductCartRequest request) {
        return ResponseEntity.ok(cartService.add(request));
    }

    @PreAuthorize("hasAuthority('CLIENT')")
    @DeleteMapping("/remove")
    public ResponseEntity<?> removeProduct(@RequestBody ProductCartRequest request) {
        return ResponseEntity.ok(cartService.remove(request));
    }
}
