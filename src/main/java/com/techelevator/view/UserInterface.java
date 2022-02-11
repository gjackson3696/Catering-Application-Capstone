package com.techelevator.view;

import java.util.Scanner;

public class UserInterface{
    private CateringInventory inventory;
    private Scanner userInput;
    private boolean isRunning = true, transactionRunning;

    public UserInterface() {
        inventory = new CateringInventory();
        userInput = new Scanner(System.in);
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void displayMainMenu() {
        displaySeparator();
        System.out.println("(1) Display Catering Items");
        System.out.println("(2) Order");
        System.out.println("(3) Quit");
        System.out.println();
        int choice = userInput.nextInt();
        while(choice<1 && choice>3) {
            choice = userInput.nextInt();
        }
        switch(choice) {
            case 1:
                displaySeparator();
                this.displayCateringItems();
                break;
            case 2:
                this.transactionRunning = true;
                Transaction newTransaction = new Transaction();
                while(transactionRunning) {
                    this.orderMenu(newTransaction);
                }
                break;
            case 3:
                this.quit();
                break;
        }
    }

    private void displayCateringItems() {
        for(String productCode : inventory.getSortedCodes()) {
            System.out.println(inventory.getProductByCode(productCode).menuString());
        }
    }

    private void orderMenu(Transaction transaction) {
        displaySeparator();
        System.out.println("(1) Add Money");
        System.out.println("(2) Select Products");
        System.out.println("(3) Complete Transaction");
        System.out.println(String.format("Current Account Balance: $%.2f",transaction.getCurrentBalance()));
        System.out.println();
        int choice = userInput.nextInt();
        while(choice<1 && choice>3) {
            choice = userInput.nextInt();
        }
        switch(choice) {
            case 1:
                displaySeparator();
                System.out.println("Please enter a dollar bill value:");
                int value = userInput.nextInt();
                try {
                    transaction.addMoney(value);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            case 2:
                displaySeparator();
                this.displayCateringItems();
                displaySeparator();
                System.out.println("Please input a product code:");
                String productCode = userInput.next();
                System.out.println("Please input a number to order:");
                int numberToOrder = userInput.nextInt();
                try {
                    transaction.productSelection(inventory,productCode,numberToOrder);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            case 3:
                this.transactionRunning = false;
                break;
        }
    }

    private void quit() {
        this.isRunning = false;
    }

    private void displaySeparator() {
        System.out.println("--------------------------------------");
    }
}
