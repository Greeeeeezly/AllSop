package com.example.excursionbookingapi.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super("Tour not found: " + message);
    }
}
