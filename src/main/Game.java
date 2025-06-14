package main;

import gameClasses.CommandRegistry;
import gameClasses.Location;
import gameClasses.Player;
import gameClasses.Puzzle;
import gameClasses.WorldMap;

public class Game {
    Player player;
    WorldMap worldMap;
    CommandRegistry commandRegistry;
    Puzzle finalPuzzle;

    public Game(Player player, WorldMap worldMap, CommandRegistry commandRegistry) {
        this.player = player;
        this.worldMap = worldMap;
        this.commandRegistry = commandRegistry;
        System.out.println("Initializing game...");
    }

    public Game() {
    }

    public void run() {
        System.out.println("Running game...");
        System.out.println("Type 'help' to see available commands.");
        System.out.println("You are trapped in a mysterious house. Your goal is to escape as soon as possible!");

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("> ");
            
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("exit")) {
                running = false;
                System.out.println("Goodbye!");
            } else if (!input.isEmpty()) {
                String[] parts = input.split("\\s+", 2);
                String command = parts[0];
                String argument = (parts.length > 1) ? parts[1] : null;

                if (command.equalsIgnoreCase("use")) {
                    if (argument == null) {
                        commandRegistry.userInput("use");
                        String saisie = scanner.nextLine().trim();
                        commandRegistry.userInput("use " + saisie);
                    } else {
                        commandRegistry.userInput("use " + argument);
                    }
                } else if (command.equalsIgnoreCase("inspect")) {
                    if (argument == null) {
                        commandRegistry.userInput("inspect");
                        System.out.print("Select the number of the item to inspect: ");
                        String saisie = scanner.nextLine().trim();
                        commandRegistry.userInput("inspect " + saisie);

                    } else {
                        commandRegistry.userInput("inspect " + argument);
                    }

                } else {
                    if (commandRegistry != null) {
                        commandRegistry.userInput(input);
                    } else {
                        System.out.println("Command system not initialized.");
                    }
                }
            }
            if (finalPuzzle != null && isFinalPuzzleSolved(finalPuzzle)) {
                System.out.println("Congratulations! You have escaped the house!");
                running = false;
            }
        }
        scanner.close();
    }

    public boolean isFinalPuzzleSolved(Puzzle finalPuzzle) {
        Location hallLeft = worldMap.getLocation(new int[] { 1, 2 });
        if (hallLeft == null)
            return false;
        return !hallLeft.getPuzzleList().contains(finalPuzzle);
    }

    public Player getPlayer() {
        return player;
    }

    public WorldMap getWorldMap() {
        return worldMap;
    }

    public CommandRegistry getCommandRegistry() {
        return commandRegistry;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    public void setCommandRegistry(CommandRegistry commandRegistry) {
        this.commandRegistry = commandRegistry;
    }

    public void setFinalPuzzle(Puzzle puzzle) {
        this.finalPuzzle = puzzle;
    }
}