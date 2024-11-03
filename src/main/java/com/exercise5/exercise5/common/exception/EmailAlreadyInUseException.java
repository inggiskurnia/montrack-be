package com.exercise5.exercise5.common.exception;

public class EmailAlreadyInUseException extends RuntimeException {
    public EmailAlreadyInUseException(){
        super("Email already in used");
    }

    public EmailAlreadyInUseException(String message) {
        super(message);
    }
}
