package com.ahmed.ecommerce.ecommerce.customer.dto;

public record CreateCustomerRequest(
        String firstName,
        String lastName,
        String email,
        String password
){}
