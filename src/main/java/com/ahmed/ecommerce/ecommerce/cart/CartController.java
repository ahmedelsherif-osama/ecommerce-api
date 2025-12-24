package com.ahmed.ecommerce.ecommerce.cart;

import com.ahmed.ecommerce.ecommerce.cart.dto.CartResponse;
import com.ahmed.ecommerce.ecommerce.cart.dto.CheckoutRequest;
import com.ahmed.ecommerce.ecommerce.cart.dto.CheckoutResponse;
import com.ahmed.ecommerce.ecommerce.order.Order;
import com.ahmed.ecommerce.ecommerce.order.OrderResponse;
import com.ahmed.ecommerce.ecommerce.payment.PaymentMethodEntity;
import com.ahmed.ecommerce.ecommerce.user.CurrentUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@PreAuthorize("isAuthenticated()")
@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;
    private final CurrentUserService currentUserService;

    public CartController(CartService cartService, CurrentUserService currentUserService) {
        this.cartService = cartService;
        this.currentUserService = currentUserService;
    }

    @GetMapping
    public CartResponse getCart() {
        return cartService.getOrCreateActiveCart(currentUserService.getCurrentUserId());
    }

        @PostMapping("/add")
        public CartResponse addVariant(@RequestParam("variantId") UUID variantId,
                                       @RequestParam("quantity") int quantity) {
            return cartService.addVariant(currentUserService.getCurrentUserId(), variantId, quantity);
        }

    @PutMapping("/update")
    public CartResponse updateVariant(@RequestParam("variantId") UUID variantId,
                                      @RequestParam("quantity") int quantity) {
        return cartService.updateVariantQuantity(currentUserService.getCurrentUserId(), variantId, quantity);
    }

    @DeleteMapping("/remove")
    public void removeVariant(@RequestParam("variantId") UUID variantId) {
        cartService.removeVariant(currentUserService.getCurrentUserId(), variantId);
    }

    @DeleteMapping("/clear")
    public void clearCart() {
        cartService.clearCart(currentUserService.getCurrentUserId());
    }

    @PostMapping("/checkout")
    public OrderResponse checkout(@RequestBody CheckoutRequest request) {
      return cartService.checkout(currentUserService.getCurrentUserId(), request.paymentMethodId());
    }
}
