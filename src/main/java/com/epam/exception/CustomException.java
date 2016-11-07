package com.epam.exception;

public class CustomException extends RuntimeException {

    public CustomException() {}

    public CustomException(String message){
        super(message);
    }

    public CustomException(Throwable cause){
        super(cause);
    }
}
