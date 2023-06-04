package com.example.ecommerce_online.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_order")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;
    @OneToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    Cart cart;
    @Column(name = "total_price", nullable = false)
    @PositiveOrZero
    BigDecimal totalPrice;
    @Column(name = "date_created", nullable = false)
    @CreationTimestamp
    LocalDateTime dateCreated;
}
