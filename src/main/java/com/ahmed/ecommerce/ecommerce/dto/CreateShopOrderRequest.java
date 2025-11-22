package com.ahmed.ecommerce.ecommerce.dto;

import java.util.List;

public record CreateShopOrderRequest(
        List<CartItemRequest> items
) {}
