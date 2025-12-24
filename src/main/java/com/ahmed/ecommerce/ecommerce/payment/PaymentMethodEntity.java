package com.ahmed.ecommerce.ecommerce.payment;

import com.ahmed.ecommerce.ecommerce.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "payment_methods")
@Getter
@Setter
public class PaymentMethodEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private PaymentMethodType type; // e.g., "CASH", "CREDIT_CARD", "PAYPAL"

    private String provider; // optional, e.g., "VISA", "Stripe", "LocalBank"

    private String details; // JSON or masked info like last4 digits for cards

    private boolean active = true;


}
