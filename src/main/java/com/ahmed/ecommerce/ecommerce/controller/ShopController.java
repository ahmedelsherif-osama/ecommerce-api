package com.ahmed.ecommerce.ecommerce.controller;

import com.ahmed.publisher.erp.dto.ProductDto;
import com.ahmed.publisher.erp.dto.OrderDto;
import com.ahmed.publisher.shop.dto.CreateShopOrderRequest;
import com.ahmed.publisher.shop.service.ShopService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/products")
    public List<ProductDto> listProducts() {
        return shopService.listProducts();
    }

    @GetMapping("/products/{id}")
    public ProductDto getProduct(@PathVariable UUID id) {
        return shopService.getProductById(id);
    }

    @PostMapping("/checkout")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto checkout(@RequestBody CreateShopOrderRequest request) {
        return shopService.checkout(request);
    }
}
