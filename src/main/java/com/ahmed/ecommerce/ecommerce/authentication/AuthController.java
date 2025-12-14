package com.ahmed.ecommerce.ecommerce.authentication;

import com.ahmed.ecommerce.ecommerce.authentication.dtos.RefreshTokenRequest;
import com.ahmed.ecommerce.ecommerce.user.old.dto.AuthResponse;
import com.ahmed.ecommerce.ecommerce.user.old.dto.LoginRequest;
import com.ahmed.ecommerce.ecommerce.user.old.dto.UserRegistrationRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody UserRegistrationRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("/refresh")
    public AuthResponse refresh(@RequestBody RefreshTokenRequest request) {
        return authService.refresh(request.getRefreshToken());
    }
}
