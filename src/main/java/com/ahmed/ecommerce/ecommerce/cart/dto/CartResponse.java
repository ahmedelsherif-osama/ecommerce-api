package com.ahmed.ecommerce.ecommerce.cart.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class CartResponse {
    private UUID cartId;
    private List<CartItemResponse> items;
    private BigDecimal totalPrice;
    private String currency;
}
