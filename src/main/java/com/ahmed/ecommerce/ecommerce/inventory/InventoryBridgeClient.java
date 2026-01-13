package com.ahmed.ecommerce.ecommerce.inventory;

import com.ahmed.ecommerce.ecommerce.inventory.dto.InventoryCheckRequest;
import com.ahmed.ecommerce.ecommerce.inventory.dto.InventoryCheckResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Component
public class InventoryBridgeClient {

    private final WebClient webClient;

    public InventoryBridgeClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public boolean isAvailable(UUID variantId, int quantity) {
        InventoryCheckRequest request =
                new InventoryCheckRequest(variantId, quantity);

        InventoryCheckResponse response =
                webClient
                        .post()
                        .uri("/bridge/inventory/check")
                        .bodyValue(request)
                        .retrieve()
                        .bodyToMono(InventoryCheckResponse.class)
                        .block(); // bewusst blockierend, da deine API synchron ist

        return response != null && response.available();
    }
}
