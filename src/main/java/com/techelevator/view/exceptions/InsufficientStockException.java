package com.techelevator.view.exceptions;

public class InsufficientStockException extends Exception{
    @Override
    public String getMessage() {
        return "Insufficient Stock!";
    }
}
