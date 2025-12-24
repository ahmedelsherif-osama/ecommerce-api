package com.ahmed.ecommerce.ecommerce.cart.dto;

import java.util.UUID;

public record CheckoutRequest(UUID paymentMethodId) {}