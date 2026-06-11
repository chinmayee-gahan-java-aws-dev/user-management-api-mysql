package com.chinmayee.rest.web.usermanagementapi.exception;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorDetails {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String details;  // lowercase 'd'

    public ErrorDetails(LocalDateTime timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;  // lowercase 'd'
    }

    public LocalDateTime getTimestamp() { 
    	return timestamp; 
    	}
    public String getMessage() {
    	return message;
}
    public String getDetails() {
    	return details;
}  // lowercase 'd'
}