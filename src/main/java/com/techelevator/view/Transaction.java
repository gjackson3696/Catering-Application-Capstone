package com.techelevator.view;

import com.techelevator.view.exceptions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transaction {
    private double currentBalance;
    List<Integer> acceptableDollarValues;

    public Transaction(){
        currentBalance=0;
        acceptableDollarValues = new ArrayList<>();
        acceptableDollarValues.add(1);
        acceptableDollarValues.add(5);
        acceptableDollarValues.add(10);
        acceptableDollarValues.add(20);
        acceptableDollarValues.add(50);
        acceptableDollarValues.add(100);
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
    }

    public int[] completeTransaction() {
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
}
