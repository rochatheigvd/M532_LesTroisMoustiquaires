package gameClasses.commands;

import gameClasses.Command;
import gameClasses.events.PlayerMovedEvent;

public class ComMove extends Command {
    public ComMove(String verb, String description) {
        super(verb, description);
    }

    @Override
    public void execute(String argument) {
        if (argument != null) {
            if (moveExist(argument)) {
                int[] nextPos = nextPosition(transcriptDirection(argument));
                if (verifNextLocationExists(nextPos)) {
                    getGame().getPlayer().setPlayerPosition(nextPos);
                    displayMove(argument, nextPos);
                    getPlayerLocation().setVisited();
                    getGame().addEvent(new PlayerMovedEvent(nextPos));
                } else {
                    System.out.println(", you can't go there.");
                }
            } else {
                System.out.println(argument + " is not an argument for the command go.");
            }
        } else {
            System.out.println("There is not argument in your command.");
        }
    }

    private void displayMove(String argument, int[] nextPos) {
        System.out.println("You just move to " + argument + ".");
        System.out.println("You are now in " + getGame().getWorldMap().getLocation(nextPos).getName() + ".");
    }

    private boolean moveExist(String argument) {
        if (argument.equals("north") || argument.equals("south") || argument.equals("east")
                || argument.equals("west")) {
            return true;
        } else {
            return false;
        }
    }

    private int[] transcriptDirection(String argument) {
        int[] move = new int[2];
        switch (argument) {
            case "north":
                move[1] = -1;
                break;
            case "south":
                move[1] = 1;
                break;
            case "west":
                move[0] = -1;
                break;
            case "east":
                move[0] = 1;
                break;
            default:
                break;
        }
        return move;
    }

    private int[] nextPosition(int[] move) {
        int[] nextPos = new int[2];
        nextPos[0] = getGame().getPlayer().getPlayerPosition()[0] + move[0];
        nextPos[1] = getGame().getPlayer().getPlayerPosition()[1] + move[1];
        return nextPos;
    }

    private boolean verifNextLocationExists(int[] nextPos) {
        if (nextPos[0] >= 0 && nextPos[1] >= 0 && nextPos[0] < getGame().getWorldMap().getXlength()
                && nextPos[1] < getGame().getWorldMap().getYlength()) {
            if (getGame().getWorldMap().getLocation(nextPos) != null) {
                if (!getGame().getWorldMap().getLocation(nextPos).getIsLocked()) {
                    return true;
                } else {
                    System.out.print("This location is locked");
                    return false;

                }
            } else {
                System.out.print("There is nothing");
                return false;

            }
        } else {
            System.out.print("This is not in the house");
            return false;

        }
    }

}