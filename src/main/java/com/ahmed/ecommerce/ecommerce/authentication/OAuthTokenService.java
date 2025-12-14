package com.ahmed.ecommerce.ecommerce.authentication;

import com.ahmed.ecommerce.ecommerce.user.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OAuthTokenService implements TokenService {

    @Override
    public Optional<String> createToken(User user) {
        return Optional.empty(); // cannot create token locally
    }

    @Override
    public boolean validate(String token) {
        // call OAuth provider introspection endpoint
        return true; // pseudo-code
    }

    @Override
    public Optional<UUID> extractUserId(String token) {
        // fetch user info from provider
        return Optional.of(UUID.randomUUID()); // pseudo-code
    }

    @Override
    public String getType() {
        return "OAuth";
    }
}
