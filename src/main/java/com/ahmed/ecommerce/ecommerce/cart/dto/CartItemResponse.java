package com.ahmed.ecommerce.ecommerce.cart.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record CartItemResponse (
       UUID variantId,
       String productName,
       int quantity,
       BigDecimal unitPrice,
       BigDecimal subtotal
) {}