package com.ahmed.ecommerce.ecommerce.exceptions.dto;

public record ErrorResponse(
        String code,
        String message
) {}
