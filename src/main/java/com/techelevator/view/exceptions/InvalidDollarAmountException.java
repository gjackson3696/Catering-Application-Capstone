package com.techelevator.view.exceptions;

public class InvalidDollarAmountException extends Exception{
    @Override
    public String getMessage() {
        return "The dollar amount entered must be $1, $5, $10, $20, $50 or $100.";
    }
}
