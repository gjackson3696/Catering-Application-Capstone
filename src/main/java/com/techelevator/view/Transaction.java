package com.techelevator.view;

import com.techelevator.view.exceptions.*;

import java.util.*;

public class Transaction {
    private double currentBalance, totalCost;
    List<Integer> acceptableDollarValues;
    Map<String,Integer> shoppingCart;

    public Transaction(){
        currentBalance=0;
        totalCost=0;
        acceptableDollarValues = new ArrayList<>();
        acceptableDollarValues.add(1);
        acceptableDollarValues.add(5);
        acceptableDollarValues.add(10);
        acceptableDollarValues.add(20);
        acceptableDollarValues.add(50);
        acceptableDollarValues.add(100);
        shoppingCart = new HashMap<>();
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public double addMoney(int dollarAmountInput) throws InvalidDollarAmountException, ExceedsMaximumTransactionException {
        if(!acceptableDollarValues.contains(dollarAmountInput)) {
            throw new InvalidDollarAmountException();
        }
        if(currentBalance+dollarAmountInput>1500) {
            throw new ExceedsMaximumTransactionException();
        }
        return currentBalance+=dollarAmountInput;
    }

    public void productSelection(CateringInventory inventory, String productCode,int numToPurchase) throws InvalidProductCodeException, InsufficientBalanceException, OutOfStockException, InsufficientStockException {
        if(Arrays.asList(inventory.getSortedCodes()).contains(productCode)==false) {
            throw new InvalidProductCodeException();
        }
        CateringItem item = inventory.getProductByCode(productCode);
        if(item.getPrice()*numToPurchase>this.currentBalance) {
            throw new InsufficientBalanceException();
        }
        item.decreaseQuantity(numToPurchase);
        this.currentBalance -= item.getPrice()*numToPurchase;
        this.totalCost += item.getPrice()*numToPurchase;
        if(shoppingCart.containsKey(productCode)) {
            shoppingCart.replace(productCode,shoppingCart.get(productCode) + numToPurchase);
        } else {
            shoppingCart.put(productCode,numToPurchase);
        }
    }

    public List<String> completeTransaction(CateringInventory inventory) {
        List<String> receipt = new ArrayList<>();

        for(String productCode : shoppingCart.keySet()) {
            CateringItem item = inventory.getProductByCode(productCode);
            receipt.add(shoppingCart.get(productCode) + "," + item.getType() + "," + item.getName() + "," + item.getPrice() + "," + (item.getPrice()*shoppingCart.get(productCode)) + "," + item.getReminder());
        }
        receipt.add(String.format("Total: $%.2f",this.totalCost));
        receipt.add(getChangeString());
        return receipt;
    }
    private int[] getChange() {
        int[] change = new int[8];
        change[0] = (int)(currentBalance/50);
        double remainingBalance = currentBalance % 50.0;

        change[1] = (int)(remainingBalance/20);
        remainingBalance = remainingBalance % 20.0;

        change[2] = (int)(remainingBalance/10);
        remainingBalance = remainingBalance % 10.0;

        change[3] = (int)(remainingBalance/5);
        remainingBalance = remainingBalance % 5.0;

        change[4] = (int)(remainingBalance/1);
        remainingBalance = remainingBalance % 1.0;

        change[5] = (int)(remainingBalance/0.25);
        remainingBalance = remainingBalance % 0.25;

        change[6] = (int)(remainingBalance/0.1);
        remainingBalance = remainingBalance % 0.1;

        change[7] = (int)(remainingBalance/0.05);
        currentBalance = 0;

        return change;
    }

    private String getChangeString() {
        int[] change = this.getChange();
        int finalIndex = 0;
        String endString, middleString = "";
        if (change[7]!=0){
            finalIndex = 7;
            endString = "("+change[7]+") Nickels in change";
        } else if (change[6]!=0) {
            finalIndex = 6;
            endString = "("+change[6]+") Dimes in change";
        } else if (change[5]!=0) {
            finalIndex = 5;
            endString = "("+change[5]+") Quarters in change";
        } else if (change[4]!=0) {
            finalIndex = 4;
            endString = "("+change[4]+") Ones in change";
        } else if(change[3]!=0) {
            finalIndex = 3;
            endString = "("+change[3]+") Fives in change";
        } else if(change[2]!=0) {
            finalIndex = 2;
            endString = "("+change[2]+") Tens in change";
        } else if(change[1]!=0) {
            finalIndex = 1;
            endString = "("+change[1]+") Twenties in change";
        } else if(change[0]!=0) {
            return "You received ("+change[0]+") Fifties in change";
        } else {
            return "You received no change";
        }

        for(int i=0; i<finalIndex; i++) {
            if(change[i]!=0) {
                switch(i) {
                    case 0:
                        middleString += "(" + change[0] + ") Fifties, ";
                    case 1:
                        middleString += "(" + change[1] + ") Twenties, ";
                        break;
                    case 2:
                        middleString += "(" + change[2] + ") Tens, ";
                        break;
                    case 3:
                        middleString += "(" + change[3] + ") Fives, ";
                        break;
                    case 4:
                        middleString += "(" + change[4] + ") Ones, ";
                        break;
                    case 5:
                        middleString += "(" + change[5] + ") Quarters, ";
                        break;
                    case 6:
                        middleString += "(" + change[6] + ") Dimes, ";
                        break;
                    case 7:
                        middleString += "(" + change[7] + ") Quarters, ";
                        break;
                }
            }
        }
        return "You received " + middleString + endString;
    }
}
