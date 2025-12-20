package com.ahmed.ecommerce.ecommerce.cart;

import com.ahmed.ecommerce.ecommerce.cart.dto.CartItemResponse;
import com.ahmed.ecommerce.ecommerce.cart.dto.CartResponse;

public class CartMapper {

    public static CartResponse toResponse(Cart cart) {
        CartResponse response = new CartResponse();
        response.setCartId(cart.getId());
        response.setTotalPrice(cart.getTotalPrice());
        response.setCurrency(cart.getCurrency());

        List<CartItemResponse> items = cart.getItems().stream()
            .map(CartMapper::toItemResponse)
            .toList();

        response.setItems(items);
        return response;
    }

    private static CartItemResponse toItemResponse(CartItem item) {
        CartItemResponse ci = new CartItemResponse();
        ci.setVariantId(item.getVariant().getId());
        ci.setProductName(item.getVariant().getProduct().getName());
        ci.setQuantity(item.getQuantity());
        ci.setUnitPrice(item.getUnitPrice());
        ci.setSubtotal(item.getSubtotal());
        return ci;
    }
}
