package com.example.coursebookingserver.exception;

public class AppUserNotFoundException extends AppBasicException{

    public AppUserNotFoundException(){
        super("User not found!");
    }
    public AppUserNotFoundException(String message) {
        super(message);
    }

    public AppUserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
