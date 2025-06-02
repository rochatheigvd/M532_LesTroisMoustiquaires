package gameClasses.commands;

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
        if (argument != null) {
            Item item = itemFinder(argument);
            if (item != null) {
                if (item instanceof Key) {
                    Key key = (Key) item;
                    if (getPlayerLocation().equals(getGame().getWorldMap().getLocation(key.getPositionUsable()))) {
                        displayUse(key);
                        List<int[]> positionsUnlockable = key.getPositionUnlockable();
                        for (int[] positions : positionsUnlockable) {
                            getGame().getWorldMap().getLocation(positions).unlockLocation();
                        }
                        getGame().getPlayer().getInventory().removeItem(item);
                    } else {
                        System.out.println("You are not in the right location.");
                    }
                } else {
                    System.out.println("This object can not be used.");
                }
            } else {
                System.out.println("There is no object with this name in your inventory.");
            }
        } else {
            System.out.println("There is not argument in your command.");
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
