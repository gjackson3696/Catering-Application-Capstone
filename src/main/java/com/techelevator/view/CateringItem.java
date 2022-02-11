package com.techelevator.view;

public abstract class CateringItem {
    private String productCode, name;
    private double price;
    private int quantity = 25;

    public CateringItem(String productCode, String name, double price) {
        this.productCode = productCode;
        this.name = name;
        this.price = price;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void decreaseQuantity(int numPurchased) {
        if(quantity==0) {
            System.out.println("Out of stock!");
        } else if(numPurchased>quantity) {
            System.out.println("Insufficient stock!");
        } else {
            quantity -= numPurchased;
        }
    }

    public abstract String getReminder();
}
