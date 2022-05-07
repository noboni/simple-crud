package com.crud.simple.ExceptionHandler;

public class NotFound extends RuntimeException {
    public NotFound(String message) {
        super(message);
    }
}
