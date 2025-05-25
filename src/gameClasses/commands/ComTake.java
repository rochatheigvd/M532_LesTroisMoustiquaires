package gameClasses.commands;

import java.util.List;
import gameClasses.*;

public class ComTake extends Command {
    public ComTake(String verb, String description) {
        super(verb, description);
    }

    @Override
    public void execute(String argument) {
        if (argument != null) {
            Item item = itemFinder(argument);
            if (item != null) {
                getGame().getPlayer().getInventory().addItem(item);
                getPlayerLocation().dropItem(item);
                System.out.println(item.getName() + " is in your inventory.");
            } else {
                System.out.println("There is no object with this name here.");
            }
        } else {
            System.out.println("There is not argument in your command.");
        }
    }

    public Item itemFinder(String argument) {
        List<Item> items = getPlayerLocation().getItemList();
        for (Item item : items) {
            if (item.getName().toLowerCase().equals(argument)) {
                return item;
            }
        }
        return null;
    }
}
