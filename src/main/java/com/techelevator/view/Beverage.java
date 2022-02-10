package com.techelevator.view;

public class Beverage extends CateringItem{
    public Beverage(String productCode, String name, double price) {
        super(productCode, name, price);
    }

    @Override
    public String getReminder() {
        return "Don't Forget Ice.";
    }
}
