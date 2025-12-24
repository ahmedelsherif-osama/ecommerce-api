package com.ahmed.ecommerce.ecommerce.payment.dto;

import com.ahmed.ecommerce.ecommerce.payment.PaymentMethodType;

import java.util.UUID;

public record PaymentMethodResponse(
        UUID id,
        PaymentMethodType type,
        String provider,
        String details,
        boolean active
) {}
