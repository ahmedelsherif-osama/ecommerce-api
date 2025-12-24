package com.ahmed.ecommerce.ecommerce.product.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record VariantResponse(
        UUID id,
        BigDecimal price,
        BigDecimal discountedPrice, // nullable
        int stockCount,
        String sku,
        String attributes
) {
}
