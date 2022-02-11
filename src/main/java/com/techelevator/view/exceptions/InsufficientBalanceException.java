package com.techelevator.view.exceptions;

public class InsufficientBalanceException extends Exception{
    @Override
    public String getMessage() {
        return "Insufficient balance to purchase.";
    }
}
