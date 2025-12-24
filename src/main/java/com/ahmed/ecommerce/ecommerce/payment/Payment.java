package com.ahmed.ecommerce.ecommerce.payment;

import com.ahmed.ecommerce.ecommerce.cart.Cart;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payments")
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethodEntity paymentMethod;

    private boolean success;

    private String transactionId; // optional, from provider

    private String failureReason; // optional

    private BigDecimal amount;

    private LocalDateTime createdAt;

    @PrePersist
    private void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
