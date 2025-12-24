package com.ahmed.ecommerce.ecommerce.payment;

import com.ahmed.ecommerce.ecommerce.payment.dto.PaymentMethodResponse;

public class PaymentMethodMapper {

    public static PaymentMethodResponse toResponse(PaymentMethodEntity entity) {
        return new PaymentMethodResponse(
                entity.getId(),
                entity.getType(),
                entity.getProvider(),
                entity.getDetails(),
                entity.isActive()
        );
    }
}
