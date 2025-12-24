package com.ahmed.ecommerce.ecommerce.product.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record ProductDto(
        UUID id,
        String name,
        List<VariantResponse> variants
) {
}
