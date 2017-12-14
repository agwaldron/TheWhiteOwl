package com.example.alec.thewhiteowl;

/**
 * Created by Alec on 12/14/2017.
 */

public class MenuItem {
    String itemName;
    String itemDescription;
    String itemPrice;

    public MenuItem(String itemName, String itemDescription, String itemPrice){
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
    }

    public String getItemName(){ return itemName; }
    public String getItemDescription(){ return itemDescription; }
    public String getItemPrice(){ return itemPrice; }
}
