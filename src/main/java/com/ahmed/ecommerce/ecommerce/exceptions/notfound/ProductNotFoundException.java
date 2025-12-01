package com.ahmed.ecommerce.ecommerce.exceptions.notfound;


import com.ahmed.ecommerce.ecommerce.exceptions.ResourceNotFoundException;

import java.util.UUID;

public class ProductNotFoundException extends ResourceNotFoundException {
    public ProductNotFoundException(UUID id) {
        super("Product with id " + id + " not found");
    }
}

