package com.ahmed.ecommerce.ecommerce.payment;

import com.ahmed.ecommerce.ecommerce.cart.Cart;

public interface PaymentProcessor {
    Payment process(Cart cart, PaymentMethodEntity method);
    PaymentMethodType supports();
}
