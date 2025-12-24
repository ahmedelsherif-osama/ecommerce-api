package com.ahmed.ecommerce.ecommerce.payment;

import com.ahmed.ecommerce.ecommerce.payment.dto.CreatePaymentMethodRequest;

import java.util.List;
import java.util.UUID;

public interface PaymentMethodService {
    PaymentMethodEntity getForUser(UUID userId, UUID paymentMethodId);
    List<PaymentMethodEntity> getAllForUser(UUID userId);
    PaymentMethodEntity create(UUID userId, CreatePaymentMethodRequest request);
    void delete(UUID userId, UUID paymentMethodId);
}
