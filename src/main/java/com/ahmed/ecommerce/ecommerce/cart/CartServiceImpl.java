package com.ahmed.ecommerce.ecommerce.cart;

import com.ahmed.ecommerce.ecommerce.cart.dto.CartResponse;
import com.ahmed.ecommerce.ecommerce.user.PaymentMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(rollbackFor = Exception.class)
public class CartServiceImpl implements CartService {
    private PaymentService paymentService;
    private CartItemService cartItemService;
    private OrderService orderService;
    private CartRepository cartRepository;

    public CartServiceImpl(PaymentService paymentService,
                           CartItemService cartItemService,
                           OrderService orderService,
                           CartRepository cartRepository) {
        this.paymentService = paymentService;
        this.cartItemService = cartItemService;
        this.orderService = orderService;
        this.cartRepository = cartRepository;
    }

    @Override
    public CartResponse getOrCreateActiveCart(UUID userId) {
        return CartMapper.toResponse(getOrCreateActiveCartEntity(userId));
    }

    @Override
    public CartResponse addVariant(UUID userId, UUID variantId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        Cart cart = getOrCreateActiveCartEntity(userId);
        cartItemService.add(cart, variantId, quantity);

        cart.calculateTotal();
        cartRepository.save(cart);

        return CartMapper.toResponse(cart);
    }

    @Override
    public CartResponse updateVariantQuantity(UUID userId, UUID variantId, int quantity) {
        Cart cart = getOrCreateActiveCartEntity(userId);

        if (quantity <= 0) {
            removeVariant(userId,variantId);
        } else {
            cartItemService.updateQuantity(cart, variantId, quantity);
        }
        cart.calculateTotal();
        return CartMapper.toResponse(cart);
    }

    @Override
    public void removeVariant(UUID userId, UUID variantId) {
        Cart cart = getOrCreateActiveCartEntity(userId);

        cartItemService.remove(cart, variantId);

        cart.calculateTotal();
        cartRepository.save(cart);
    }


    @Override
    public void clearCart(UUID userId) {
        Cart cart = getOrCreateActiveCartEntity(userId);

        cartItemService.clear(cart);

        cart.calculateTotal();
        cartRepository.save(cart);
    }


    @Override
    public Order checkout(UUID userId, PaymentMethod method) {
        Cart cart = getOrCreateActiveCartEntity(userId);

        if (cart.getItems() == null || cart.getItems().isEmpty()) {
            throw new IllegalStateException("Cannot checkout empty cart");
        }

        // 1. Charge payment (external side-effect)
        paymentService.pay(cart, method);

        // 2. Create order from cart
        Order order = orderService.createFromCart(cart);

        // 3. Finalize cart
        cartItemService.clear(cart);
        cart.calculateTotal();

        // Optional future use
        // cart.markCheckedOut();

        cartRepository.save(cart);

        return order;
    }

}
