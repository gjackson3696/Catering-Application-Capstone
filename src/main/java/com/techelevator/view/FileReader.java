package com.techelevator.view;

import javax.accessibility.AccessibleValue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileReader {

    public Map<String, CateringItem> populateMap() {
        File file = new File("cateringsystem.csv");
        try(Scanner menuScanner=new Scanner(file);){

            Map<String, CateringItem> productInventory= new HashMap<>();
            while(menuScanner.hasNextLine()) {
                String[] inventoryInput = menuScanner.nextLine().split("|");
                switch (inventoryInput[0]) {
                    case "A":
                        Appetizer appetizer = new Appetizer(inventoryInput[1], inventoryInput[2], Double.parseDouble(inventoryInput[3]));
                        productInventory.put(inventoryInput[1], appetizer);
                        break;
                    case "B":
                        Beverage beverage = new Beverage(inventoryInput[1], inventoryInput[2], Double.parseDouble(inventoryInput[3]));
                        productInventory.put(inventoryInput[1], beverage);
                        break;
                    case "D":
                        Dessert dessert = new Dessert(inventoryInput[1], inventoryInput[2], Double.parseDouble(inventoryInput[3]));
                        productInventory.put(inventoryInput[1], dessert);
                        break;
                    case "E":
                        Entree entree = new Entree(inventoryInput[1], inventoryInput[2], Double.parseDouble(inventoryInput[3]));
                        productInventory.put(inventoryInput[1], entree);
                        break;
                }
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("File not Found");
        }

        return null;
    }



}
