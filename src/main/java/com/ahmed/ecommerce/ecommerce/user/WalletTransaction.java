package com.ahmed.ecommerce.ecommerce.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class WalletTransaction {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid")
    private UUID id;

    @ManyToOne
    private StoreWallet wallet;

    private BigDecimal amount;
    private TransactionType type;
    private String description;

    private LocalDateTime createdAt;

}
