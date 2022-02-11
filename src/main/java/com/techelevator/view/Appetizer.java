package com.techelevator.view;

public class Appetizer extends CateringItem{
    public Appetizer(String productCode, String name, double price) {
        super(productCode, name, price);
    }

    @Override
    public String getReminder() {
        return "You might need extra plates.";
    }
}
