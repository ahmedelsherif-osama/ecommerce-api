package com.ahmed.ecommerce.ecommerce.product.dto;

import java.math.BigDecimal;

public record PatchProductRequest(
        String name,
        BigDecimal price
) {
}
