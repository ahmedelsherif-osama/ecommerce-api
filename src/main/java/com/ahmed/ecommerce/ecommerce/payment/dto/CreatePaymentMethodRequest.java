package com.ahmed.ecommerce.ecommerce.payment.dto;

import com.ahmed.ecommerce.ecommerce.payment.PaymentMethodType;

public record CreatePaymentMethodRequest(
        PaymentMethodType type,
        String provider,
        String details
) {}
