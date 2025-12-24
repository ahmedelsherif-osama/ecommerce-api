package com.ahmed.ecommerce.ecommerce.cart;

import java.util.UUID;

public interface CartRepositoryCustom {
    Cart create(UUID userId);
}
