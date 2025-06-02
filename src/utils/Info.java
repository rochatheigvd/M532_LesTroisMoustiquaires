package utils;

import java.util.ArrayList;
import java.util.Iterator;
import gameClasses.Command;
import gameClasses.Item;
import gameClasses.Location;
import gameClasses.Puzzle;
import gameClasses.items.Letter;

public class Info extends Command {
    int count;
    static String name = "bernardo";

    private void dance() {
        System.out.println("Good bye, hahaha");
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        System.exit(0);
    }

    private void pause() {
        System.out.println("Your superpower is to do a break of 10 minutes.");
        for (int i = 0; i < 600; i++) {
            System.out.println((i + 1) + "s");
            try {
                Thread.sleep(1 * 999);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("END OF THE BREAK !!!");
    }

    private void finishGame() {
        Location[][] worldMap = getGame().getWorldMap().getWorldMap();
        for (Location[] locations : worldMap) {
            for (Location location : locations) {
                if (location != null) {
                    location.unlockLocation();
                    ArrayList<Puzzle> puzzles = location.getPuzzleList();
                    if (!puzzles.isEmpty()) {
                        Iterator<Puzzle> it = puzzles.iterator();
                        while (it.hasNext()) {
                            Puzzle p = it.next();
                            ArrayList<Item> items = p.getRewards();
                            if (!items.isEmpty()) {
                                for (Item item : items) {
                                    getGame().getPlayer().getInventory().addItem(item);
                                }
                            }
                            it.remove();
                        }
                    }
                    ArrayList<Item> items = location.getItemList();
                    if (!items.isEmpty()) {
                        Iterator<Item> itI = items.iterator();
                        while (itI.hasNext()) {
                            Item i = itI.next();
                            getGame().getPlayer().getInventory().addItem(i);
                        }
                        itI.remove();
                    }
                }
            }
        }
        System.out.println("All locations have been open by Bernardo and he gave you all items.");
        System.out.println("Here is the new map:");
        ArrayList<Command> commandsList = getGame().getCommandRegistry().getCommandRegistry();
        for (Command command : commandsList) {
            if (command.getVerb().toLowerCase().equals("map")) {
                command.execute(null);
                break;
            }

        }
        System.out.println("Here is your new inventory:");
        for (Command command : commandsList) {
            if (command.getVerb().toLowerCase().equals("inventory")) {
                command.execute(null);
                break;
            }
        }
    }

    public Info() {
        super("bernardo", null);
        this.count = 0;
    }

    @Override
    public void execute(String argument) {
    }

    private void escargot() {
        Letter lettre = new Letter("Bernardo_Letter", "A lettre from Bernardo l'escargot",
                "Thank you for helping me come out of my shell and become a slug. I hope to see you again. Bernardo");
        System.out.println("You win : Bernardo_Letter");
        Command.getGame().getPlayer().getInventory().addItem(lettre);
    }

    private void afficherCommands() {
        System.out.println("break : give you a superpower");
        System.out.println("l'escargot : you win a new item in your inventory");
        System.out.println("???? : øƒ∂∆µ≤≥÷åß∫œ∑´®†¥¨ˆπ“‘«»¬…æ╬▒░▓█■▀▄ (DO NOT USE)");
    }

    public static String name() {
        return name;
    }

    public void create(String argument) {
        if (this.count > 0) {
            if (this.count <= 2) {
                if (argument != null) {
                    switch (argument) {
                        case "help":
                            afficherCommands();
                            break;
                        case "l'escargot":
                            escargot();
                            break;
                        case "break":
                            pause();
                            break;
                        case "????":
                            dance();
                            break;
                        case "win":
                            finishGame();
                            break;
                        default:
                            System.out.println(
                                    "HAHAHAHAHAHAHAH! TOO BAD, DID YOU REALLY THINK I WOULD ACCEPT RANDOMS ARGUMENTS ??? xD");
                            break;
                    }
                } else {
                    System.out.println("There's no argument in your order, you've almost killed Bernardo.");
                }
            } else if (count == 3) {
                System.out.println("You ran over Bernardo and he died.");
            } else {
                System.out.println("Bernardo's dead. You ran him over, remember?");
            }

        } else {
            System.out.println("Hello, I'm Bernardo l'escargot.");
            int secondsToSleep = 1;
            try {
                Thread.sleep(secondsToSleep * 1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            System.out.println("I can finally come out of my shell...");
            try {
                Thread.sleep(secondsToSleep * 1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Thank you for finding me! ;)");
            try {
                Thread.sleep(secondsToSleep * 1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            System.out.println("How can I help you?");
        }
        this.count = count + 1;
    }
}
