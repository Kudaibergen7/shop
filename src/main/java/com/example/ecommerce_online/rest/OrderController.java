package com.example.ecommerce_online.rest;

import com.example.ecommerce_online.model.request.CreateOrderRequest;
import com.example.ecommerce_online.service.OrderService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
@SecurityRequirement(name = "shop")
public class OrderController {
    private final OrderService orderService;

    @PreAuthorize("hasAuthority('CLIENT')")
    @PostMapping("/")
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest request) {
        return ResponseEntity.ok(orderService.create(request));
    }
    @PreAuthorize("hasAuthority('CLIENT')")
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.get(id));
    }
}
