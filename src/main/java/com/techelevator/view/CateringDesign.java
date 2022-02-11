package com.techelevator.view;public @interface CateringDesign {
//    ------- Main operating class
//    Class Application -> CateringSystemsCLI
//
//    calls displayMainMenu(inventory) inside while() loop
//
//        -----
//
//    Class MainMenu -> UserInterface
//            displayMainMenu(CateringInventory)
//
//    displaySubMenu(inventory)
//
//    CateringInventory inventory = new CateringInventory()
//
//    calls displayItems()
//
//    Utilizes Transaction
//
//    MenuString
//    public String toString() {
//        if(get.QUANTITY!=0) {
//            return String.format(" %-15s%-20s%-10d$%.2f", get.PRODUCT_CODE, get.NAME, get.QUANTITY, get.PRICE);
//        } else {
//            return String.format(" %-15s%-20s%-10s$%.2f", get.PRODUCT_CODE, get.NAME, "SOLD OUT", get.PRICE);
//        }
//    }
//
//
//        -----
//    Class CateringInventory
//    newPopulatedMap
//    Map<String PRODUCT_CODE,CateringItem> inventory
//
//        --	Beverage beverage = new Beverage("B1","Cola",2.00);
//        ex.	inventory.put("B1"(beverage.getID),beverage);
//    CateringItem item = inventory.get("B1");
//        --	item.getReminder()
//
//
//    public displayItems()
//
//    public orderItem()
//    public orderItem(int numToOrder)
//
//        ------
//    Class FileReader
//
//        Arrays.sort()
//    set keyset to a array, sort array= sorted array
//    returns sortedArray
//    Populate the Map in the constructor using Scanner on File delimited by |
//
//    reutrns newpoulatedmap
//        ------
//
//    Class Transaction- shopping cart
//    double currentBalance,
//
//
//        -----
//
//    Abstract Class CateringItem
//    String PRODUCT_CODE, NAME
//    double PRICE
//    int QUANTITY = 25;
//
//    public CateringItem(PRODUCT_CODE,NAME,PRICE)
//
//    public getters; no setters
//
//    public decreaseQuantity();
//    public decreaseQuantity(int numToDecrease);
//
//    public abstract String reminder();
//
//
//
//
//        ------Classes to return reminder statements
//
//    Class Beverage extends CateringItem
//    String reminder() return "Don't Forget Ice"
//
//    Class Entree extends CateringItem
//    String reminder "Did you remember Dessert?"
//
//    Class Appetizer extends CateringItem
//    String reminder "You might need extra plates."
//
//    Class Dessert extends CateringItem
//    String reminder "Coffee goes with dessert."
//
//            -----
//
//    Notes and possibilities
//
//
//        *Class Customer*
//    Map<String PRODUCT_CODE,Integer QUANTITY> customer cart;
//
//    Class Logger
//            ,totalSales

}
