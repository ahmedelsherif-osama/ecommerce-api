package com.ahmed.ecommerce.ecommerce.product.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record UpdateProductRequest(
        @NotNull String name,
        @NotNull BigDecimal price
        ) {
}
