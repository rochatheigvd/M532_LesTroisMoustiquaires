package gameClasses.commands;

import java.util.List;
import gameClasses.*;

public class ComSay extends Command {
    public ComSay(String verb, String description) {
        super(verb, description);
    }

    @Override
    public void execute(String argument) {
        if (argument != null) {
            if (!getPlayerLocation().getPuzzleList().isEmpty()) {
                Puzzle p = verifSolution(argument);
                if (p != null) {
                    List<Item> items = p.getRewards();
                    getPlayerLocation().dropPuzzle(p);
                    if (!items.isEmpty()) {
                        System.out.println("Congratulations! You solved the puzzle.");
                        System.out.print("You win : ");
                        for (int i = 0; i < items.size(); i++) {
                            Item item = items.get(i);
                            getGame().getPlayer().getInventory().addItem(item);
                            if (i == items.size() - 1) {
                                System.out.println(item.getName() + ".");
                            } else {
                                System.out.print(item.getName() + ", ");
                            }
                        }
                    } else {
                        System.out.println("The puzzle gave you nothing.");
                    }
                } else {
                    System.out.println("This is not the good solution. Try again.");
                }
            } else {
                System.out.println("There is no puzzle in " + getPlayerLocation().getName() + ".");
            }
        } else {
            System.out.println("There is not argument in your command.");
        }
    }

    private Puzzle verifSolution(String argument) {
        List<Puzzle> puzzles = getPlayerLocation().getPuzzleList();
        for (Puzzle puzzle : puzzles) {
            if (puzzle.getSolution().toLowerCase().equals(argument)) {
                return puzzle;
            }
        }
        return null;
    }
}
