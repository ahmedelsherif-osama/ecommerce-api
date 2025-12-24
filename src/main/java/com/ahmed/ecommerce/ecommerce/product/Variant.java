package com.ahmed.ecommerce.ecommerce.product;


import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Variant {
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private BigDecimal price;
    private BigDecimal discountedPrice; // nullable
    private int stockCount;

    private String sku;
    private String attributes; // e.g., JSON {"size": "M", "color": "Red"}
}
