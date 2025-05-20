package gameClasses;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> itemList;

    public Inventory() {
        this.itemList = new ArrayList<>();
    }

    getItemList() {
        return this.itemList;
    }

    public void addItem(Item item) {
        this.itemList.add(item);
    }

    public void removeItem(Item item) {
        this.itemList.remove(item);
    }

    public Item getItem(String name) { 
           
    }
}
