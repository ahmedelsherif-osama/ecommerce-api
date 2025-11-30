package com.ahmed.ecommerce.ecommerce.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {
    private UUID id;
    private String name;
    private BigDecimal price;
}
