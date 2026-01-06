package com.ahmed.ecommerce.ecommerce.inventory.dto;

public record InventoryCheckResponse(
        boolean available,
        int availableQuantity
) {}

