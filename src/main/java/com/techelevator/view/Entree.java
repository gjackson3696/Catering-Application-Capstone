package com.techelevator.view;

public class Entree extends CateringItem{
    public Entree(String productCode, String name, double price) {
        super(productCode, name, price);
    }

    @Override
    public String getReminder() {
        return "Did you remember Dessert?";
    }
}
