package com.ahmed.ecommerce.ecommerce.user.dto;

public record UserRegistrationRequest(
        String firstName,
        String lastName,
        String email,
        String password
){}
