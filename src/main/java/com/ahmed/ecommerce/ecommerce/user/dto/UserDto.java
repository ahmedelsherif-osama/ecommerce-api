package com.ahmed.ecommerce.ecommerce.user.dto;
import java.util.UUID;

public record UserDto(
        UUID id,
        String firstName,
        String lastName
) {
}
