package gameClasses.commands;

import java.util.List;

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
            List<Item> i = getGame().getPlayer().getInventory().getItemList();
            if (i.size() > 0) {
                for (int j = 0; j < i.size(); j++) {
                    System.out.println("(" + (j + 1) + ") " + i.get(j).getName());
                }
                System.out.println("Which item do you want to inspect?");
                int input = -1;

                java.util.Scanner scanner = new java.util.Scanner(System.in);
                do {
                    while (!scanner.hasNextInt()) {
                        System.out.println("This is not an integer, try again. ");
                        scanner.next();
                    }
                    input = scanner.nextInt();
                    if (input < 1 || input > i.size()) {
                        if (i.size() > 1) {
                            System.out.println("The number must be between " + 1 + " and " + i.size() + ".");
                        } else {
                            System.out.println("The number must be 1");
                        }

                    }
                } while (input < 1 || input > i.size());

                if (input != -1) {
                    displayItem(i.get(input - 1));
                }
            } else {
                System.out.println("There is nothing in your inventory.");
            }
        }
    }

    private void displayItem(Item i) {
        System.out.println("Inspecting " + i.getName());
        System.out.println("The item says " + '"' + i.inspect() + '"' + '.');
    }
}