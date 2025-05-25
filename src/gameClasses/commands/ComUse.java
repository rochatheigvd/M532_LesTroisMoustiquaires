package gameClasses.commands;

import java.util.List;

import gameClasses.Command;
import gameClasses.Item;

public class ComUse extends Command {
    public ComUse(String verb, String description) {
        super(verb, description);
    }

    @Override
    public void execute(String argument) {
        if (argument != null) {
            Item item = itemFinder(argument);
            if (item != null) {
                // code à implémenter ici.
            }
            System.out.println("There is no object with this name in your inventory.");
        } else {
            System.out.println("There is not argument in your command.");
        }
    }

    public Item itemFinder(String argument) {
        return getGame().getPlayer().getInventory().getItem(argument);
    }
}
