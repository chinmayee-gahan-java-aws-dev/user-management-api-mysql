package com.chinmayee.rest.web.usermanagementapi.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}