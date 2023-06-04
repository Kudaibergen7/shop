package com.example.ecommerce_online.model.entity;

import com.example.ecommerce_online.model.enums.ProductStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.jasypt.encryption.BigDecimalEncryptor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_product")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(nullable = false, length = 50)
    String name;
    @Column(nullable = false, length = 100)
    String description;
    String image;
    BigDecimal price;
    BigDecimal discount;
    @ManyToOne
    @JoinColumn(name = "category")
    Category category;
    @Enumerated(EnumType.STRING)
    @Column(name = "product_status")
    ProductStatus productStatus;
    @CreationTimestamp
    LocalDateTime dateCreated;
    @PositiveOrZero
    BigDecimal discountedPrice;
}
