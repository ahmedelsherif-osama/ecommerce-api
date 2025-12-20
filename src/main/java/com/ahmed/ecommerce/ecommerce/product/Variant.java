package com.ahmed.ecommerce.ecommerce.product;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Variant {
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private BigDecimal price;
    private BigDecimal discountPrice; // nullable
    private int stockCount;

    private String sku;
    private String attributes; // e.g., JSON {"size": "M", "color": "Red"}
}
