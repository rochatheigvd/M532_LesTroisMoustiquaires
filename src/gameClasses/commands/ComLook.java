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
        System.out.println(location.getName() + " description: " + location.getDescr());
        System.out.print("You see " + location.getItemList().size() + " item");
        if (location.getItemList().size() > 1) {
            System.out.print("s");
        } else if (location.getItemList().size() == 1){
            System.out.print("");
        }

        System.out.print(" and " + location.getPuzzleList().size() + " puzzle");
        if (location.getPuzzleList().size() > 1) {
                System.out.print("s");
        } else if (location.getPuzzleList().size() == 1){
                System.out.print("");
        }
        System.out.println(".");
        int i;
        for (i = 0; i < location.getItemList().size(); i++) {
            System.out.print("  - " +
                    location.getItemList().get(i).getName() + ": " + location.getItemList().get(i).getLookDescr());
            if (i < location.getItemList().size() - 1) {
                System.out.print(", ");
            } else {
                System.out.println(".");
            }
        }
        for (i = 0; i < location.getPuzzleList().size(); i++) {
            System.out.print("  - Puzzle " + (i + 1) + ": " + location.getPuzzleList().get(i).getDescrPuzzle());
            if (i < location.getPuzzleList().size() - 1) {
                System.out.print(", ");
            } else {
                System.out.println(".");
            }
        }
    }
}