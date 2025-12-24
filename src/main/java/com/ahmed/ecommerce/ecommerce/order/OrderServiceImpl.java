package com.ahmed.ecommerce.ecommerce.order;

import com.ahmed.ecommerce.ecommerce.cart.Cart;
import com.ahmed.ecommerce.ecommerce.cart.CartItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderResponse createFromCart(Cart cart) {
        Order order = new Order();
        order.setUser(cart.getUser());
        order.setTotalPrice(cart.getTotalPrice());

        order.setItems(
            cart.getItems().stream().map(cartItem -> {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrder(order);
                orderItem.setVariant(cartItem.getVariant());
                orderItem.setQuantity(cartItem.getQuantity());
                orderItem.setUnitPrice(cartItem.getUnitPrice());
                orderItem.setSubtotal(cartItem.getSubtotal());
                return orderItem;
            }).collect(Collectors.toList())
        );

        return OrderMapper.toResponse(orderRepository.save(order));
    }

    @Override
    public OrderResponse updateStatus(UUID orderId, OrderStatus status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
        order.setStatus(status);
        return OrderMapper.toResponse(orderRepository.save(order));
    }

    @Override
    public List<OrderResponse> getOrdersForUser(UUID userId) {
        return orderRepository.findByUserId(userId).stream()
                .map(OrderMapper::toResponse)
                .toList();
    }

    @Override
    public OrderResponse getOrderForUser(UUID userId, UUID orderId) {
        Order order = orderRepository.findById(orderId)
                .filter(o -> o.getUser().getId().equals(userId))
                .orElseThrow(() -> new IllegalArgumentException("Order not found for user"));

        return OrderMapper.toResponse(order);
    }


}
