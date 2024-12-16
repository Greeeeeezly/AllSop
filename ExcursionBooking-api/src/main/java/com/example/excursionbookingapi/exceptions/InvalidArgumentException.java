package com.example.excursionbookingapi.exceptions;

public class InvalidArgumentException extends RuntimeException {

    public InvalidArgumentException(String message) {
        super("invalid request: " + message);
    }

}
