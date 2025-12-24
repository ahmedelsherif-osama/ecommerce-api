package com.ahmed.ecommerce.ecommerce.order;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderItemResponse(
        UUID variantId,
        int quantity,
        BigDecimal unitPrice,
        BigDecimal subtotal
) {}