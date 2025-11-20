package com.ahmed.ecommerce.ecommerce.common.exceptions;

public class ResourceNotFoundException extends  RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }
}
