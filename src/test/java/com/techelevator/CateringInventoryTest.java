package com.techelevator;

import com.techelevator.view.CateringInventory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CateringInventoryTest {
    private CateringInventory inventory;
    private String[] codes;
    @Before
    public void setup() { // Revise if menu changes
        inventory = new CateringInventory();
        codes = new String[] {
                "A1", "A2", "A3", "A4",
                "B1", "B2", "B3", "B4", "B5",
                "D1", "D2", "D3", "D4", "D5",
                "E1", "E2", "E3", "E4"
        };
    }

    @Test
    public void testGetSortedCodes() {
        Assert.assertArrayEquals(codes,inventory.getSortedCodes());
    }
}
