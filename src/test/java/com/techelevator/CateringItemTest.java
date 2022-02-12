package com.techelevator;

import com.techelevator.view.Appetizer;
import com.techelevator.view.Beverage;
import com.techelevator.view.Dessert;
import com.techelevator.view.Entree;
import com.techelevator.view.exceptions.InsufficientStockException;
import com.techelevator.view.exceptions.OutOfStockException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CateringItemTest {
    private Appetizer appetizer;
    private Beverage beverage;
    private Dessert dessert;
    private Entree entree;
    @Before
    public void setup() {
        appetizer = new Appetizer("A1","C Sharp Cheese Plate",3.5);
        beverage = new Beverage("B1","Soda",1.50);
        dessert = new Dessert("D1","NY Style Cheesecake",2.55);
        entree = new Entree("E1","Chicken Pot Pie",8.85);
    }

    @Test
    public void testDecreaseQuantity() {
        try {
            appetizer.decreaseQuantity(8);
            beverage.decreaseQuantity(12);
            dessert.decreaseQuantity(5);
            entree.decreaseQuantity(25);
        } catch(Exception e) {
        }
        Assert.assertEquals(17,appetizer.getQuantity());
        Assert.assertEquals(13,beverage.getQuantity());
        Assert.assertEquals(20,dessert.getQuantity());
        Assert.assertEquals(0,entree.getQuantity());
        try {
            beverage.decreaseQuantity(20); //Throw InsufiicientStockException
            entree.decreaseQuantity(5); //Throw OutOfStockException
        } catch(OutOfStockException e) {
            Assert.assertEquals("Out of Stock!",e.getMessage());
        } catch(InsufficientStockException e) {
            Assert.assertEquals("Insufficient Stock!",e.getMessage());
        }
    }
}
