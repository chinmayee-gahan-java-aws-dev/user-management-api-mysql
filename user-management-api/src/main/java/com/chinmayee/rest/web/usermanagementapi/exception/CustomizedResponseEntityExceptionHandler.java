package com.chinmayee.rest.web.usermanagementapi.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice  // This makes it global for all controllers
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    // Handle our custom exception
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(
            UserNotFoundException ex, WebRequest request) {
        
        ErrorDetails errorDetails = new ErrorDetails(
            LocalDateTime.now(),
            ex.getMessage(),
            request.getDescription(false)
        );
        
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    // Handle all other exceptions
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(
            Exception ex, WebRequest request) {
        
        ErrorDetails errorDetails = new ErrorDetails(
            LocalDateTime.now(),
            ex.getMessage(),
            request.getDescription(false)
        );
        
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}