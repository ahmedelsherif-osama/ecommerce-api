package com.ahmed.ecommerce.ecommerce.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class ResourceNotFoundException extends  RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }
}
