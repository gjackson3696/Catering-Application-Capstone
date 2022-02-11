package com.techelevator.view.exceptions;

public class OutOfStockException extends Exception{
    @Override
    public String getMessage() {
        return "Out of Stock!";
    }
}
