package com.example.excursionbookingapi.exceptions;

public class BookingNotFoundException extends RuntimeException{
    public BookingNotFoundException(String message) {
        super("Booking not found: " + message);
    }
}
