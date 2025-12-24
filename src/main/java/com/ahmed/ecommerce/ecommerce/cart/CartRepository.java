package com.ahmed.ecommerce.ecommerce.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID>, CartRepositoryCustom {

    // Find active cart for a user
    @Query("SELECT c FROM Cart c WHERE c.user.id = :userId AND c.status = 'ACTIVE'")
    Optional<Cart> getCartByUserId(@Param("userId") UUID userId);

    // Save is inherited from JpaRepository

}
