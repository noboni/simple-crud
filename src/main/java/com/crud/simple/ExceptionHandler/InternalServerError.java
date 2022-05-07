package com.crud.simple.ExceptionHandler;

public class InternalServerError extends RuntimeException {
    public InternalServerError(String message){
        super(message);
    }
}
