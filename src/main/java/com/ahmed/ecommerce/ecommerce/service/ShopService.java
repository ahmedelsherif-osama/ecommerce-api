package com.ahmed.ecommerce.ecommerce.service;

import com.ahmed.publisher.erp.dto.ProductDto;
import com.ahmed.publisher.erp.service.ProductService;
import com.ahmed.publisher.shop.dto.CartItemRequest;
import com.ahmed.publisher.shop.dto.CreateShopOrderRequest;
import com.ahmed.publisher.erp.dto.CreateOrderRequest;
import com.ahmed.publisher.erp.dto.CreateOrderItemRequest;
import com.ahmed.publisher.erp.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopService {

    private final ProductService productService;
    private final com.ahmed.publisher.erp.service.OrderService orderService;

    public ShopService(ProductService productService,
                       com.ahmed.publisher.erp.service.OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    public List<ProductDto> listProducts() {
        return productService.findAll();
    }

    public ProductDto getProductById(java.util.UUID id) {
        return productService.findById(id);
    }

    public OrderDto checkout(CreateShopOrderRequest request) {

        List<CreateOrderItemRequest> orderItems = request.items().stream()
                .map(item -> new CreateOrderItemRequest(item.productId(), item.quantity()))
                .collect(Collectors.toList());

        CreateOrderRequest orderRequest = new CreateOrderRequest(orderItems);

        return orderService.create(orderRequest);
    }
}
