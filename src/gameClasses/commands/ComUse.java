package gameClasses.commands;

import java.util.ArrayList;
import java.util.List;

import gameClasses.Command;
import gameClasses.Item;
import gameClasses.items.*;

public class ComUse extends Command {
    public ComUse(String verb, String description) {
        super(verb, description);
    }

    @Override
    public void execute(String argument) {
        if (argument == null) {
            // Display usable items (keys) with numbers
            List<Item> inventory = getGame().getPlayer().getInventory().getItemList();
            List<Key> keys = new ArrayList<>();
            int index = 1;

            System.out.println("Usable items in your inventory:");
            for (Item item : inventory) {
                if (item instanceof Key) {
                    keys.add((Key) item);
                    System.out.println(index + ". " + item.getName());
                    index++;
                }
            }

            if (keys.isEmpty()) {
                System.out.println("You have no usable items.");
                return;
            }

            System.out.print("Select the number of the item to use: ");
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            String saisie = scanner.nextLine().trim();
            execute(saisie);

        } else {
            try {
                // Essaie d'abord de parser comme un nombre
                int itemIndex = Integer.parseInt(argument) - 1;
                List<Item> inventory = getGame().getPlayer().getInventory().getItemList();
                List<Key> keys = new ArrayList<>();

                for (Item item : inventory) {
                    if (item instanceof Key) {
                        keys.add((Key) item);
                    }
                }

                if (itemIndex >= 0 && itemIndex < keys.size()) {
                    useKey(keys.get(itemIndex));
                } else {
                    System.out.println("Invalid item number.");
                }
            } catch (NumberFormatException e) {
                // Si ce n'est pas un nombre, cherche par nom
                Item item = itemFinder(argument.toLowerCase());
                if (item != null) {
                    if (item instanceof Key) {
                        useKey((Key) item);
                    } else {
                        System.out.println("This object cannot be used.");
                    }
                } else {
                    System.out.println("There is no object with this name in your inventory.");
                }
            }
        }
    }


    private void useKey(Key key) {
        if (getPlayerLocation().equals(getGame().getWorldMap().getLocation(key.getPositionUsable()))) {
            displayUse(key);
            List<int[]> positionsUnlockable = key.getPositionUnlockable();
            for (int[] positions : positionsUnlockable) {
                getGame().getWorldMap().getLocation(positions).unlockLocation();
            }
            getGame().getPlayer().getInventory().removeItem(key);
        } else {
            System.out.println("You are not in the right location to use this key.");
        }
    }

    private void displayUse(Key key) {
        System.out.print("You used " + key.getName() + ", it opens ");
        List<int[]> positionsUnlockable = key.getPositionUnlockable();
        for (int i = 0; i < positionsUnlockable.size(); i++) {
            int[] is = positionsUnlockable.get(i);
            System.out.print(getGame().getWorldMap().getLocation(is).getName());
            if (i != (positionsUnlockable.size()-1)) {
                System.out.print(", ");
            }
        }
        System.out.println(".");
    }

    private Item itemFinder(String argument) {
        return getGame().getPlayer().getInventory().getItem(argument);
    }
}
