package com.example.coursebookingserver.exception;

public class CourseNotFoundException extends AppBasicException{

    public CourseNotFoundException(){
        super("Course not found!");
    }
    public CourseNotFoundException(String message) {
        super(message);
    }

    public CourseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
