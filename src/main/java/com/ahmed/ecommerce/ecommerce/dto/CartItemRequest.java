package com.ahmed.ecommerce.ecommerce.dto;

import java.util.UUID;

public record CartItemRequest(
        UUID productId,
        int quantity
) {}
