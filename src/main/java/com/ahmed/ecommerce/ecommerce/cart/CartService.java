package com.ahmed.ecommerce.ecommerce.cart;


import com.ahmed.ecommerce.ecommerce.cart.dto.CartResponse;
import com.ahmed.ecommerce.ecommerce.user.PaymentMethod;

import java.util.UUID;

public interface CartService {

    CartResponse getOrCreateActiveCart(UUID userId);

    CartResponse addVariant(UUID userId, UUID variantId, int quantity);

    CartResponse updateVariantQuantity(UUID userId, UUID variantId, int quantity);

    void removeVariant(UUID userId, UUID variantId);

    void clearCart(UUID userId);

    Order checkout(UUID userId, PaymentMethod method);
}
