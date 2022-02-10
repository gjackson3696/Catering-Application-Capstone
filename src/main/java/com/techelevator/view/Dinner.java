package com.techelevator.view;

public class Dinner extends CateringItem{
    public Dinner(String productCode, String name, double price) {
        super(productCode, name, price);
    }

    @Override
    public String getReminder() {
        return "Did you remember Dessert?";
    }
}
