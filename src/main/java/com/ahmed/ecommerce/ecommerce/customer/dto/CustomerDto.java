package com.ahmed.ecommerce.ecommerce.customer.dto;
import java.util.UUID;

public record CustomerDto(
        UUID id,
        String firstName,
        String lastName
) {
}
