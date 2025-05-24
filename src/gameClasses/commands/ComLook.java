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
        System.out.println("You see " + location.getItemList().size() + " items");
        int i;
        for (i = 0; i < location.getItemList().size(); i++) {
            System.out.print("a " + location.getItemList().get(i).getLookDescr());
            if (i < location.getItemList().size() - 1) {
                System.out.print(", ");
            } else {
                System.out.println(".");
            }
        }
        for (i = 0; i < location.getPuzzleList().size(); i++) {
            System.out.print("a " + location.getPuzzleList().get(i).getDescrPuzzle());
            if (i < location.getPuzzleList().size() - 1) {
                System.out.print(", ");
            } else {
                System.out.println(".");
            }
        }
    }
}