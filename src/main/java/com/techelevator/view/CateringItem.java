package com.techelevator.view;

import com.techelevator.view.exceptions.InsufficientStockException;
import com.techelevator.view.exceptions.OutOfStockException;

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

    public void decreaseQuantity(int numPurchased) throws OutOfStockException, InsufficientStockException {
        if(quantity==0) {
            throw new OutOfStockException();
        } else if(numPurchased>quantity) {
            throw new InsufficientStockException();
        } else {
            quantity -= numPurchased;
        }
    }

    public String menuString() {
        if(this.quantity!=0) {
            return String.format(" %-10s%-25s%-10d$%.2f",this.productCode,this.name,this.quantity,this.price);
        } else {
            return String.format(" %-10s%-25s%-10s$%.2f",this.productCode,this.name,"SOLD OUT",this.price);
        }
    }

    public abstract String getReminder();
}
