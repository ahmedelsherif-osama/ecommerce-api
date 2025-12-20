package com.ahmed.ecommerce.ecommerce.cart;

import com.ahmed.ecommerce.ecommerce.user.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "carts")
@Getter
public class Cart {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid")
    private UUID id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private CartStatus status = CartStatus.ACTIVE;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> items = new ArrayList<>();

    private BigDecimal totalPrice = BigDecimal.ZERO;
    private String currency = "EGP";

    // ----------------------------
    // JPA requirement
    // ----------------------------
    protected Cart() {}

    public Cart(User user) {
        this.user = user;
    }

    // ----------------------------
    // Controlled mutations
    // ----------------------------
    void addItem(CartItem item) {
        items.add(item);
    }

    void removeItem(CartItem item) {
        items.remove(item);
    }

    public void markCheckedOut() {
        this.status = CartStatus.CHECKED_OUT;
    }

    public void markAbandoned() {
        this.status = CartStatus.ABANDONED;
    }

    // ----------------------------
    // Total calculation (private)
    // ----------------------------
    void calculateTotal() {
        if (items.isEmpty()) {
            this.totalPrice = BigDecimal.ZERO;
            return;
        }

        this.totalPrice = items.stream()
                .map(item -> {
                    item.updateSubtotal();
                    return item.getSubtotal();
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // ----------------------------
    // Lifecycle hooks
    // ----------------------------
    @PrePersist
    void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
