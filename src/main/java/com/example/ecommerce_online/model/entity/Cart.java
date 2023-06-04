package com.example.ecommerce_online.model.entity;

import lombok.Data;
import org.springframework.context.annotation.Profile;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Cart {
    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToMany(fetch = FetchType.LAZY)
    List<Product> products = new ArrayList<>();
}
