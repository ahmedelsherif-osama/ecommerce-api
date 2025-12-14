package com.ahmed.ecommerce.ecommerce.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "wallets")
public class StoreWallet {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid")
    private UUID id;

    private BigDecimal amount;
    private String currency;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @Version
    private Long version;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
