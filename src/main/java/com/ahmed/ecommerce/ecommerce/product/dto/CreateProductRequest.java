package com.ahmed.ecommerce.ecommerce.product.dto;

import java.math.BigDecimal;
import java.util.List;

public record CreateProductRequest(
        String name,
        String description,
        List<CreateVariantRequest> variants
) {}

