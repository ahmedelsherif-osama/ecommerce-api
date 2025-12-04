package com.ahmed.ecommerce.ecommerce.customer.dto;
import jakarta.validation.constraints.NotNull;

public record UpdateCustomerRequest(
        @NotNull String firstName,
        @NotNull String lastName
        ) {}
