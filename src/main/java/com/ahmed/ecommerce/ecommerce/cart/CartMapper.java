package com.ahmed.ecommerce.ecommerce.cart;

import com.ahmed.ecommerce.ecommerce.cart.dto.CartItemResponse;
import com.ahmed.ecommerce.ecommerce.cart.dto.CartResponse;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CartMapper {

    public static CartResponse toResponse(Cart cart) {
        List<CartItemResponse> items = cart.getItems().stream()
                .map(CartMapper::toItemResponse)
                .toList();
        CartResponse response = new CartResponse(
                cart.getId(),
                items,
                cart.getTotalPrice(),
                cart.getCurrency()
        );
        return response;
    }

    private static CartItemResponse toItemResponse(CartItem item) {
        CartItemResponse ci = new CartItemResponse(

       item.getVariant().getId(),
       item.getVariant().getProduct().getName(),
       item.getQuantity(),
       item.getUnitPrice(),
       item.getSubtotal());
        return ci;
    }
}
