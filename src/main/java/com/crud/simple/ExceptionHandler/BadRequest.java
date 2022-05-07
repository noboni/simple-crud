package com.crud.simple.ExceptionHandler;

public class BadRequest extends RuntimeException {
    public BadRequest(String message){
        super(message);
    }
}
