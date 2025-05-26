package gameClasses.commands;

import java.util.ArrayList;

import gameClasses.Command;
import gameClasses.Item;

public class ComInventory extends Command {
    public ComInventory(String verb, String description) {
        super(verb, description);
    }

    @Override
    public void execute(String argument) {
        displayInventory(getGame().getPlayer().getInventory().getItemList());
    }

    private void displayInventory(ArrayList<Item> itemList) {
        if (!itemList.isEmpty()) {
            for (Item item : itemList) {
                System.out.println("  - " + item.getName() + " : " + item.getLookDescr());
            }
        } else {
            System.out.println("Your inventory is empty.");
        }

    }
}
