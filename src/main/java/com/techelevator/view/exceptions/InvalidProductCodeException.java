package com.techelevator.view.exceptions;

public class InvalidProductCodeException extends Exception {
    @Override
    public String getMessage() {
        return "The entered product code does not exist.";
    }
}
