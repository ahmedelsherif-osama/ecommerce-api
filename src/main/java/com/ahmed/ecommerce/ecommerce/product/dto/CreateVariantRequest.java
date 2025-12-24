package com.ahmed.ecommerce.ecommerce.product.dto;

import java.math.BigDecimal;

public record CreateVariantRequest(
        BigDecimal price,
        BigDecimal discountedPrice,
        int stockCount,
        String sku,
        String attributes
) {}
