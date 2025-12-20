package com.ahmed.ecommerce.ecommerce.cart;

import com.ahmed.ecommerce.ecommerce.product.Variant;
import jakarta.persistence.EntityNotFoundException;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

public class CartItemServiceImpl implements CartItemService {

    private final VariantRepository variantRepository;
    private final CartItemRepository cartItemRepository;

    public CartItemServiceImpl(
            VariantRepository variantRepository,
            CartItemRepository cartItemRepository
    ) {
        this.variantRepository = variantRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public void add(Cart cart, UUID variantId, int quantity) {
        Variant variant = getVariantOrThrow(variantId);

        validateStock(variant, quantity);

        CartItem item = cartItemRepository
                .findByCartAndVariant(cart, variant)
                .orElseGet(() -> createNewItem(cart, variant));

        item.setQuantity(item.getQuantity() + quantity);
        item.updateSubtotal();
    }

    @Override
    public void updateQuantity(Cart cart, UUID variantId, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }

        Variant variant = getVariantOrThrow(variantId);

        if (quantity == 0) {
            remove(cart, variantId);
            return;
        }

        validateStock(variant, quantity);

        CartItem item = cartItemRepository
                .findByCartAndVariant(cart, variant)
                .orElseThrow(() ->
                        new EntityNotFoundException("Item not found in cart")
                );

        item.setQuantity(quantity);
        item.updateSubtotal();
    }

    @Override
    public void remove(Cart cart, UUID variantId) {
        Variant variant = getVariantOrThrow(variantId);

        CartItem item = cartItemRepository
                .findByCartAndVariant(cart, variant)
                .orElseThrow(() ->
                        new EntityNotFoundException("Item not found in cart")
                );

        cart.getItems().remove(item);
    }

    @Override
    public void clear(Cart cart) {
        cart.getItems().clear();
    }

    // --------------------
    // Helpers
    // --------------------

    private Variant getVariantOrThrow(UUID variantId) {
        return variantRepository.findById(variantId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Variant not found")
                );
    }

    private void validateStock(Variant variant, int quantity) {
        if (variant.getStockCount() < quantity) {
            throw new IllegalStateException("Insufficient stock");
        }
    }

    private CartItem createNewItem(Cart cart, Variant variant) {
        CartItem item = new CartItem();
        item.setCart(cart);
        item.setVariant(variant);
        item.setQuantity(0);
        item.setUnitPrice(resolvePrice(variant));
        item.updateSubtotal();

        cart.getItems().add(item);
        return item;
    }

    private BigDecimal resolvePrice(Variant variant) {
        return variant.getDiscountedPrice() != null
                ? variant.getDiscountedPrice()
                : variant.getPrice();
    }
}
