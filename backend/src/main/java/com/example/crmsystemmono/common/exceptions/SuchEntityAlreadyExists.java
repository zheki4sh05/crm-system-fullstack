package com.example.crmsystemmono.common.exceptions;

public class SuchEntityAlreadyExists extends RuntimeException{
    public SuchEntityAlreadyExists() {

    }

    public SuchEntityAlreadyExists(String message) {
        super(message);
    }
}
