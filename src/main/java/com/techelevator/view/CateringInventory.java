package com.techelevator.view;

import java.util.Arrays;
import java.util.Map;

public class CateringInventory {
    private Map<String, CateringItem> cateringInventory;
    public CateringInventory(){
        cateringInventory=FileReader.populateMap();
    }
    public CateringItem getProductByCode(String productCode){
        return cateringInventory.get(productCode);
    }
    public String[] getSortedCodes(){
        String[] sortedCodes = cateringInventory.keySet().toArray(new String[1]);
        Arrays.sort(sortedCodes);
        return sortedCodes;
    }
}
