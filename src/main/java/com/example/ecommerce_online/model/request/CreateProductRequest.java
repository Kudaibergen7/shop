package com.example.ecommerce_online.model.request;

import com.example.ecommerce_online.model.enums.ProductStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class CreateProductRequest {
    String name;
    String description;
    String image;
    BigDecimal price;
    BigDecimal discount;
    Long category;
    ProductStatus productStatus;
}
