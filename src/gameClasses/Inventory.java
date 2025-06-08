package gameClasses;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> itemList;

    public Inventory() {
        this.itemList = new ArrayList<>();
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public void addItem(Item item) {
        this.itemList.add(item);
    }

    public void removeItem(Item item) {
        this.itemList.remove(item);
    }

    public Item getItem(String name) {
        Item itemToFind = null;
        for (Item item : this.itemList) {
            if (item.getName().toLowerCase().equals(name)) {
                itemToFind = item;
            }
        }
        return itemToFind;
    }
}