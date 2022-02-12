package com.techelevator;

import com.techelevator.view.CateringInventory;
import com.techelevator.view.CateringItem;
import com.techelevator.view.Transaction;
import com.techelevator.view.exceptions.ExceedsMaximumTransactionException;
import com.techelevator.view.exceptions.InvalidDollarAmountException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransactionTest {
    private Transaction test = new Transaction();
    private CateringInventory inventory = new CateringInventory();
    private String[] testCodes = {"A1","B1","D1","E1"};

    @Test
    public void testAddMoney() {
        try{
            Assert.assertEquals(50.00,test.addMoney(50),0.001);
            Assert.assertEquals(150.00,test.addMoney(100),0.001);
            Assert.assertEquals(170.00,test.addMoney(20),0.001);
            Assert.assertEquals(270.00,test.addMoney(100),0.001);
            test.addMoney(24);
        } catch(InvalidDollarAmountException e) {
            Assert.assertEquals("The dollar amount entered must be $1, $5, $10, $20, $50 or $100.", e.getMessage());
        } catch(ExceedsMaximumTransactionException e) {
            Assert.assertEquals("Cannot exceed maximum balance of $1500.00", e.getMessage());
        }
    }

    @Test
    public void testProductSelection() {
        try{
            for(int i=0; i<5; i++) {
                test.addMoney(100);
            }
            double balance = test.getCurrentBalance();

            test.productSelection(inventory,testCodes[0],5);
            balance -= (5*inventory.getProductByCode(testCodes[0]).getPrice());
            Assert.assertEquals(balance,test.getCurrentBalance(), 0.001);

            test.productSelection(inventory,testCodes[1],10);
            balance -= (10*inventory.getProductByCode(testCodes[1]).getPrice());
            Assert.assertEquals(balance,test.getCurrentBalance(), 0.001);

            test.productSelection(inventory,testCodes[2],15);
            balance -= (15*inventory.getProductByCode(testCodes[2]).getPrice());
            Assert.assertEquals(balance,test.getCurrentBalance(), 0.001);

            test.productSelection(inventory,testCodes[3],3);
            balance -= (3*inventory.getProductByCode(testCodes[3]).getPrice());
            Assert.assertEquals(balance,test.getCurrentBalance(), 0.001);

            Assert.assertEquals(20,inventory.getProductByCode(testCodes[0]).getQuantity());
            Assert.assertEquals(15,inventory.getProductByCode(testCodes[1]).getQuantity());
            Assert.assertEquals(10,inventory.getProductByCode(testCodes[2]).getQuantity());
            Assert.assertEquals(22,inventory.getProductByCode(testCodes[3]).getQuantity());
        } catch(Exception e) {
            Assert.fail();
        }
    }

    @Test
    public void testCompleteTransaction() {
        List<String> result = new ArrayList<>();
        try {
            for(int i=0; i<5; i++) {
                test.addMoney(100);
            }
            for(String code : testCodes) {
                test.productSelection(inventory,code,10);
                CateringItem item = inventory.getProductByCode(code);
                result.add("10,"+item.getType()+","+item.getName()+","+item.getPrice()+","+(10*item.getPrice())+","+item.getReminder());
            }
        } catch(Exception e) {
        }
        result.add("Total: $164.00");
        result.add("You received (6) Fifties, (1) Twenties, (1) Tens, (1) Fives, (1) Ones in change");
        String[] resultArray = result.toArray(new String[0]);
        Arrays.sort(resultArray);
        String[] testArray = test.completeTransaction(inventory).toArray(new String[0]);
        Arrays.sort(testArray);
        Assert.assertArrayEquals(resultArray,testArray);
    }
}
