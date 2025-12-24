package com.ahmed.ecommerce.ecommerce.cart;

import com.ahmed.ecommerce.ecommerce.user.User;
import com.ahmed.ecommerce.ecommerce.user.UserRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class CartRepositoryImpl implements CartRepositoryCustom {

    private final UserRepository userRepository;
    private final EntityManager em;

    public CartRepositoryImpl(UserRepository userRepository, EntityManager em) {
        this.userRepository = userRepository;
        this.em = em;
    }

    @Override
    public Cart create(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Cart cart = new Cart(user);
        em.persist(cart);
        return cart;
    }
}
