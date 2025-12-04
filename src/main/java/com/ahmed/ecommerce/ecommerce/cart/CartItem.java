package com.ahmed.ecommerce.ecommerce.cart;

import com.ahmed.ecommerce.ecommerce.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid")
    UUID id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal subtotal;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    @PrePersist
    private void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    private void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public void updateSubtotal() {
        this.subtotal = unitPrice.multiply(BigDecimal.valueOf(quantity));
    }
}
