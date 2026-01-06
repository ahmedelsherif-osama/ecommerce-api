package com.ahmed.ecommerce.ecommerce.inventory;

import com.ahmed.ecommerce.ecommerce.inventory.dto.InventoryCheckRequest;
import com.ahmed.ecommerce.ecommerce.inventory.dto.InventoryCheckResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class InventoryBridgeClient {

    private final RestTemplate restTemplate;

    public InventoryBridgeClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean isAvailable(UUID variantId, int quantity) {
        InventoryCheckRequest request =
                new InventoryCheckRequest(variantId, quantity);

        InventoryCheckResponse response =
                restTemplate.postForObject(
                        "http://bridge-service/bridge/inventory/check",
                        request,
                        InventoryCheckResponse.class
                );

        return response != null && response.available();
    }
}
