package com.example.fintectapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class ExceptionObject {
    private String message;
    private String error;
    private HttpStatus status;
    private LocalDateTime timestamp;

    public ExceptionObject() {
        this.timestamp = LocalDateTime.now();
    }

    public ExceptionObject(String message, String error, HttpStatus status) {
        this();
        this.message = message;
        this.error = error;
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
