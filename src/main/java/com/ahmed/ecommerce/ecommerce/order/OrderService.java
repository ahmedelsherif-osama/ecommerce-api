package com.ahmed.ecommerce.ecommerce.order;

import com.ahmed.ecommerce.ecommerce.cart.Cart;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    OrderResponse createFromCart(Cart cart);
    OrderResponse updateStatus(UUID orderId, OrderStatus status);
    List<OrderResponse> getOrdersForUser(UUID userId);
    OrderResponse getOrderForUser(UUID userId, UUID orderId);
}
