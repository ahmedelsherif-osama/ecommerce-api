package com.ahmed.ecommerce.ecommerce.cart;

import java.util.UUID;

public interface CartItemService {

    void add(Cart cart, UUID variantId, int quantity);

    void updateQuantity(Cart cart, UUID variantId, int quantity);

    void remove(Cart cart, UUID variantId);

    void clear(Cart cart);
}
