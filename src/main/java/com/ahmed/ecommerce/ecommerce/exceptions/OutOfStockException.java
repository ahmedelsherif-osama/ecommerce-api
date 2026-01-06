package com.ahmed.ecommerce.ecommerce.exceptions;

public class OutOfStockException extends RuntimeException {

    public OutOfStockException(String message) {
        super(message);
    }
}
