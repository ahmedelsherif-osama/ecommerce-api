package com.ahmed.ecommerce.ecommerce.cart.dto;

import com.ahmed.ecommerce.ecommerce.order.Order;
import lombok.Setter;

import java.util.UUID;

public record CheckoutResponse(UUID orderId, String status, double total) {
    public static CheckoutResponse fromOrder(Order order) {
        return new CheckoutResponse(
                order.getId(),
                order.getStatus().name(),
                order.getTotalPrice().doubleValue()
        );
    }
}
