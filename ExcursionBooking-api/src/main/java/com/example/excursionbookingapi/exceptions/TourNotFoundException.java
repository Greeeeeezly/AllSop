package com.example.excursionbookingapi.exceptions;

public class TourNotFoundException extends RuntimeException{
    public TourNotFoundException(String message) {
        super("Tour not found: " + message);
    }
}
