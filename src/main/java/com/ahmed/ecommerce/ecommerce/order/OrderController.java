package com.ahmed.ecommerce.ecommerce.order;

import com.ahmed.ecommerce.ecommerce.user.CurrentUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final CurrentUserService currentUserService;

    public OrderController(OrderService orderService,
                           CurrentUserService currentUserService) {
        this.orderService = orderService;
        this.currentUserService = currentUserService;
    }

    @GetMapping
    public List<OrderResponse> getMyOrders() {
        return orderService.getOrdersForUser(
                currentUserService.getCurrentUserId()
        );
    }

    @GetMapping("/{orderId}")
    public OrderResponse getOrderById(@PathVariable UUID orderId) {
        return orderService.getOrderForUser(
                currentUserService.getCurrentUserId(),
                orderId
        );
    }

    /*
    @PostMapping("/{orderId}/cancel")
    @PreAuthorize("hasRole('ADMIN')")
    public void cancelOrder(@PathVariable UUID orderId) {
        orderService.cancel(orderId);
    }
    */
}
