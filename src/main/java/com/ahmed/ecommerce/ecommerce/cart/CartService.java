package com.ahmed.ecommerce.ecommerce.cart;


import com.ahmed.ecommerce.ecommerce.cart.dto.CartResponse;
import com.ahmed.ecommerce.ecommerce.order.Order;
import com.ahmed.ecommerce.ecommerce.order.OrderResponse;
import com.ahmed.ecommerce.ecommerce.payment.PaymentMethodEntity;

import java.util.UUID;

public interface CartService {

    CartResponse getOrCreateActiveCart(UUID userId);

    CartResponse addVariant(UUID userId, UUID variantId, int quantity);

    CartResponse updateVariantQuantity(UUID userId, UUID variantId, int quantity);

    void removeVariant(UUID userId, UUID variantId);

    void clearCart(UUID userId);

    OrderResponse checkout(UUID userId, UUID paymentMethodId);
}
