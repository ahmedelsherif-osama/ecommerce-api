package com.ahmed.ecommerce.ecommerce.inventory.dto;

import java.util.UUID;

public record InventoryCheckRequest(
        UUID variantId,
        int quantity
) {}
