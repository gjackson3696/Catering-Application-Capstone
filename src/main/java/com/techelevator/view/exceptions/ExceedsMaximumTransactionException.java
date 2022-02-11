package com.techelevator.view.exceptions;

public class ExceedsMaximumTransactionException extends Exception{
    @Override
    public String getMessage() {
        return "Cannot exceed maximum balance of $1500.00";
    }
}
