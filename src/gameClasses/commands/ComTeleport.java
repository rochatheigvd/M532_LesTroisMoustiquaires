package gameClasses.commands;

import gameClasses.Command;
import gameClasses.Location;

public class ComTeleport extends Command {

    public ComTeleport(String verb, String description) {
        super(verb, description);
    }

    @Override
    public void execute(String argument) {
        boolean find = false;
        if (argument != null) {
            Location[][] worldmap = getGame().getWorldMap().getWorldMap();
            int x = getGame().getWorldMap().getXlength();
            int y = getGame().getWorldMap().getYlength();
            for (int i = 0; i < x; i++) {
                Location[] locations = worldmap[i];
                for (int j = 0; j < y; j++) {
                    Location location = locations[j];
                    if (location != null) {

                        if (location.getName().toLowerCase().equals(argument)) {
                            find = true;
                            if (!location.getName().equals(getPlayerLocation().getName())) {
                                if (location.getVisited()) {
                                    getGame().getPlayer().setPlayerPosition(new int[] { i, j });
                                    System.out.println("You have been teleported to " + location.getName() + ".");
                                    break;
                                } else {
                                    System.out.println("You never visited this location.");
                                    break;
                                }
                            } else {
                                System.out.println("You are already here.");
                            }
                        }
                    }
                }
            }
            if (!find) {
                System.out.println("This location does not exist.");
            }
        }
    }

}
