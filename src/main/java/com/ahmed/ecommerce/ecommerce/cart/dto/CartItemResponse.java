package com.ahmed.ecommerce.ecommerce.cart.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class CartItemResponse {
    private UUID variantId;
    private String productName;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal subtotal;
}