package com.example.crmsystemmono.api.exceptions;

public class WrongApiKeyException extends RuntimeException{
    public WrongApiKeyException(String message) {
        super(message);
    }
}
