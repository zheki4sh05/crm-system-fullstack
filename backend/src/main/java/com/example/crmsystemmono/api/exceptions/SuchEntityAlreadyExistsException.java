package com.example.crmsystemmono.api.exceptions;

public class SuchEntityAlreadyExistsException extends RuntimeException{

    public SuchEntityAlreadyExistsException(String message) {
        super(message);
    }
}
