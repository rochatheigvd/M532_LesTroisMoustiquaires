package gameClasses.commands;

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
                        getGame().getWorldMap().getLocation(key.getPositionUnlockable()).unlockLocation();
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
        System.out.println("You used " + key.getName() + ", it open "
                + getGame().getWorldMap().getLocation(key.getPositionUnlockable()).getName() + ".");
    }

    private Item itemFinder(String argument) {
        return getGame().getPlayer().getInventory().getItem(argument);
    }
}
