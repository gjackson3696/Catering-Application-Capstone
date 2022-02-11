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
        System.out.println("(1) Display Catering Items");
        System.out.println("(2) Order");
        System.out.println("(3) Quit");
        int choice = userInput.nextInt();
        while(choice<1 && choice>3) {
            choice = userInput.nextInt();
        }
        switch(choice) {
            case 1:
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

    }

    private void orderMenu(Transaction transaction) {
        System.out.println("(1) Add Money");
        System.out.println("(2) Select Products");
        System.out.println("(3) Complete Transaction");
        System.out.println(String.format("Current Account Balance: $%.2f",transaction.getCurrentBalance()));
        int choice = userInput.nextInt();
        while(choice<1 && choice>3) {
            choice = userInput.nextInt();
        }
        switch(choice) {
            case 1:
                System.out.println("Please enter a dollar bill value:");
                int value = userInput.nextInt();
                try {
                    transaction.addMoney(value);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            case 2:

                break;
            case 3:
                this.transactionRunning = false;
                break;
        }
    }

    private void quit() {
        this.isRunning = false;
    }
}
