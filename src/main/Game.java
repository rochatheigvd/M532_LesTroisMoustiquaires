package main;

import gameClasses.CommandRegistry;
import gameClasses.Player;
import gameClasses.WorldMap;

public class Game {
    Player player;
    WorldMap worldMap;
    CommandRegistry commandRegistry;

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

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("exit")) {
                running = false;
                System.out.println("Goodbye!");
            } else if (!input.isEmpty()) {
                if (commandRegistry != null) {
                    commandRegistry.userInput(input);
                } else {
                    System.out.println("Command system not initialized.");
                }
            }
        }
        scanner.close();
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

}