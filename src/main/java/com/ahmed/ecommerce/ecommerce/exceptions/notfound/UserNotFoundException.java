package com.ahmed.ecommerce.ecommerce.exceptions.notfound;



import com.ahmed.ecommerce.ecommerce.exceptions.ResourceNotFoundException;

import java.util.UUID;

public class UserNotFoundException extends ResourceNotFoundException {
    public UserNotFoundException(UUID id) {
        super("User with id " + id + " not found");
    }
}

