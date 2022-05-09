package com.example.coursebookingserver.exception;

public class AppBasicException extends RuntimeException {

    public AppBasicException(String message) {
        super(message);
    }

    public AppBasicException(String message, Throwable cause) {
        super(message, cause);
    }
}
