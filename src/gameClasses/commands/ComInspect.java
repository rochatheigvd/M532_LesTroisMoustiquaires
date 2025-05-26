package gameClasses.commands;

import gameClasses.Command;
import gameClasses.Item;

public class ComInspect extends Command {

    public ComInspect(String verb, String description) {
        super(verb, description);
    }

    @Override
    public void execute(String argument) {
        if (argument != null) {
            Item i = getGame().getPlayer().getInventory().getItem(argument);
            if (i != null) {
                displayItem(i);
            } else {
                System.out.println("This item does not exist in your inventory.");
            }
        } else {
            System.out.println("There is not argument in your command.");
        }
    }

    private void displayItem(Item i) {
        System.out.println("Inspecting " + i.getName());
        System.out.println("The item says " + '"' + i.getInspectDescr() + '"' + '.');
    }
}