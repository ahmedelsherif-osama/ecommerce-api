package com.ahmed.ecommerce.ecommerce.product;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductDto(
        UUID id,
        String name,
        BigDecimal price
) {
}
