package com.example.crmsystemmono.common.exceptions;

import java.time.*;

public record ApiErrorResponse(String uri, String message, Integer statusCode, LocalDateTime localDateTime) {
}
