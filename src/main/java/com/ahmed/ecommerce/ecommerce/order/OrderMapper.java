package com.ahmed.ecommerce.ecommerce.order;

public class OrderMapper {
    public static OrderResponse toResponse(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getTotalPrice(),
                order.getStatus(),
                order.getCreatedAt(),
                order.getItems().stream()
                        .map(item -> new OrderItemResponse(
                                item.getVariant().getId(),
                                item.getQuantity(),
                                item.getUnitPrice(),
                                item.getSubtotal()
                        )).toList()
        );
    }
}
