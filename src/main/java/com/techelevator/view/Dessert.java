package com.techelevator.view;

public class Dessert extends CateringItem{
    public Dessert(String productCode, String name, double price) {
        super(productCode, name, price);
    }

    @Override
    public String getReminder() {
        return "Coffee goes with dessert.";
    }
}
