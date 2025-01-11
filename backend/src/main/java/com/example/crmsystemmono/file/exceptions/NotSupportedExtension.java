package com.example.crmsystemmono.file.exceptions;

public class NotSupportedExtension extends Exception{
    public NotSupportedExtension(String message) {
        super(message);
    }

    public NotSupportedExtension() {
        super("Not supported extension");
    }
}
