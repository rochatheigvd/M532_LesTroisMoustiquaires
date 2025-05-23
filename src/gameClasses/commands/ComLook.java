package gameClasses.commands;

import gameClasses.Command;
import gameClasses.Location;

public class ComLook extends Command {
   public ComLook(String verb, String description) {
        super(verb, description);
    }

   @Override
    public void execute(String argument) {
        this.displayLook(this.getPlayerLocation());
    }

    private void displayLook(Location location) {
        System.out.println("You see a " + location.getItemList().size() + " items");
        int i;

        if(location.getItemList().size() == 0 && location.getPuzzleList().size() == 0) {
            System.out.println("There are no items in this location.");
        } else {
            for (i = 0; i <= location.getItemList().size(); i++) {
                System.out.println("a " + location.getItemList().get(i).getLookDescr());
                if (i < location.getItemList().size()) {
                    System.out.println(", ");
                } else {
                    System.out.println(".");
                }
            }

            for (i = 0; i <= location.getPuzzleList().size(); i++) {
                System.out.println("a " + location.getPuzzleList().get(i).getDescrPuzzle());
                if (i < location.getItemList().size()) {
                    System.out.println(", ");
                    System.out.println(".");
                }
            }
        }
    }
}
