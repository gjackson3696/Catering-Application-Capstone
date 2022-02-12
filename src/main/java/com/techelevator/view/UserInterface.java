package com.techelevator.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface{
    private CateringInventory inventory;
    private Scanner userInput;
    private Transaction transaction;
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
        int choice = 0;
        try {
            while (choice < 1 || choice > 3) {
                choice = userInput.nextInt();
            }
        } catch(Exception e) {
            System.out.println("Please choose a valid input.");
        }
        switch(choice) {
            case 1:
                displaySeparator();
                this.displayCateringItems();
                break;
            case 2:
                this.transactionRunning = true;
                transaction = new Transaction();
                while(transactionRunning) {
                    this.orderMenu(transaction);
                }
                break;
            case 3:
                this.quit();
                break;
        }
        userInput.nextLine();
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
        int choice = 0;
        try {
            userInput.nextLine();
            choice = userInput.nextInt();
        } catch(Exception e) {
            System.out.println("Please choose a valid input.");
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
                displayReceipt(transaction.completeTransaction(inventory));
                break;
        }
    }

    private void displayReceipt(List<String> receipt) {
        String[] receiptValues = receipt.toArray(new String[0]);
        for(String s: receiptValues) {
            String[] line = s.split(",");
            try{
                Integer.parseInt(line[0]);
                System.out.println(String.format("%-5s%-10s%-25s$%-10.2f$%-5.2f  %5s",line[0],line[1],line[2],Double.parseDouble(line[3]),Double.parseDouble(line[4]),line[5]));
            } catch(NumberFormatException ex) {
                if(line[0].equals("Total")) {
                    System.out.println("Total: $" + line[1]);
                } else {
                    System.out.println(s);
                }
            }
        }
    }

    private void quit() {
        this.isRunning = false;
    }

    private void displaySeparator() {
        System.out.println("--------------------------------------");
    }
}
