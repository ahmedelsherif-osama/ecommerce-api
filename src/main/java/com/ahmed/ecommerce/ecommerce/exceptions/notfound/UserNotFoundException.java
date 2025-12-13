package com.ahmed.ecommerce.ecommerce.exceptions.notfound;



import com.ahmed.ecommerce.ecommerce.exceptions.ResourceNotFoundException;

import java.util.UUID;

public class CustomerNotFoundException extends ResourceNotFoundException {
    public CustomerNotFoundException(UUID id) {
        super("Customer with id " + id + " not found");
    }
}

