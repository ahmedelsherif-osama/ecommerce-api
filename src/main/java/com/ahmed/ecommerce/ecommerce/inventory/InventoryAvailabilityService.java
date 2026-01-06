package com.ahmed.ecommerce.ecommerce.inventory;

import com.ahmed.ecommerce.ecommerce.exceptions.OutOfStockException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InventoryAvailabilityService {

    private final InventoryBridgeClient bridgeClient;

    public InventoryAvailabilityService(InventoryBridgeClient bridgeClient) {
        this.bridgeClient = bridgeClient;
    }

    public void assertAvailable(UUID variantId, int quantity) {
        if (!bridgeClient.isAvailable(variantId, quantity)) {
            throw new OutOfStockException("Item is out of stock");
        }
    }
}
