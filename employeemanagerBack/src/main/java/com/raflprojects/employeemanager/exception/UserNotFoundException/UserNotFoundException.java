package com.raflprojects.employeemanager.exception.UserNotFoundException;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException (String message) {
        //bellow it sends the message to the runtimeexception constructor.
        super(message);
    }
}
