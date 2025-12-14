package com.ahmed.ecommerce.ecommerce.authentication;

import com.ahmed.ecommerce.ecommerce.user.dto.AuthResponse;
import com.ahmed.ecommerce.ecommerce.user.dto.LoginRequest;
import com.ahmed.ecommerce.ecommerce.user.dto.UserRegistrationRequest;


public interface AuthService {
    AuthResponse register(UserRegistrationRequest request);
    AuthResponse login(LoginRequest request);
    AuthResponse refresh(String refreshToken);
}

