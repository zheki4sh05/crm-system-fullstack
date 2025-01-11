package com.example.crmsystemmono.common.exceptions;

public class UserWithSuchEmailAlreadyExistsException extends RuntimeException{
    public UserWithSuchEmailAlreadyExistsException(String message) {
        super(message);
    }

    public UserWithSuchEmailAlreadyExistsException() {
    }
}
