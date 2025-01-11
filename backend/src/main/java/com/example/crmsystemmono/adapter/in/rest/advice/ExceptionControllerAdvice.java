package com.example.crmsystemmono.adapter.in.rest.advice;
import com.example.crmsystemmono.common.exceptions.*;
import jakarta.persistence.*;
import jakarta.servlet.http.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.*;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> exceptionEntityNotFound(EntityNotFoundException e, HttpServletRequest request) {

        var error = new ApiErrorResponse(
                request.getRequestURI(),
                e.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SuchEntityAlreadyExists.class)
    public ResponseEntity<ApiErrorResponse> exceptionSuchEntityAlreadyExists(SuchEntityAlreadyExists e, HttpServletRequest request) {
        var error = new ApiErrorResponse(
                request.getRequestURI(),
                e.getMessage(),
                HttpStatus.CONFLICT.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorResponse> exceptionBadRequest(RuntimeException e,HttpServletRequest request) {
        var error = new ApiErrorResponse(
                request.getRequestURI(),
                e.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UserWithSuchEmailAlreadyExistsException.class)
    public ResponseEntity<ApiErrorResponse> exceptionSuchEmailAlreadyExists(UserWithSuchEmailAlreadyExistsException e, HttpServletRequest request) {
        var error = new ApiErrorResponse(
                request.getRequestURI(),
                e.getMessage(),
                HttpStatus.CONFLICT.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
    }
