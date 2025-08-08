package com.example.people_sync_backend.shared.classes.errors;

public class InvalidSortParameterException extends RuntimeException {

    public InvalidSortParameterException(String message) {
        super(message);
    }
    
}
