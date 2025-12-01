package com.ahmed.ecommerce.ecommerce.exceptions;

import java.time.LocalDateTime;

public record CustomErrorResponse(String message, LocalDateTime timestamp, String path) {
}
