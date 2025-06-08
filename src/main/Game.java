package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import gameClasses.CommandRegistry;
import gameClasses.GameState;
import gameClasses.Location;
import gameClasses.Player;
import gameClasses.Puzzle;
import gameClasses.Save;
import gameClasses.WorldMap;
import gameClasses.Item;
import gameClasses.events.GameEvent;
import gameClasses.Initialisation;

public class Game {
    private Player player;
    private WorldMap worldMap;
    private CommandRegistry commandRegistry;
    private Puzzle finalPuzzle;
    private Save currentSave;

    public Game() {
        this.currentSave = new Save();
    }

    // Helper method to find an item by its name in the world map
    private Item findItemByName(String name) {
        for (int i = 0; i < worldMap.getXlength(); i++) {
            for (int j = 0; j < worldMap.getYlength(); j++) {
                Location loc = worldMap.getLocation(new int[] { i, j });
                if (loc != null && loc.getItemList() != null) {
                    for (Item item : loc.getItemList()) {
                        if (item != null && item.getName().equals(name)) {
                            return item;
                        }
                    }
                }
            }
        }
        // Also check player's inventory in case the item is already picked up
        if (player != null && player.getInventory() != null) {
            for (Item item : player.getInventory().getItemList()) {
                if (item != null && item.getName().equals(name)) {
                    return item;
                }
            }
        }
        return null;
    }

    public void addEvent(GameEvent event) {
        currentSave.addEvent(event);
    }

    public Save getCurrentSave() {
        return currentSave;
    }

    public void loadGame() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("game_save.dat"))) {
        // Charge d'abord la sauvegarde
        this.currentSave = (Save) ois.readObject();
        
        // Initialise un nouveau jeu
        Initialisation init = new Initialisation();
        init.loadSavedGame(this); // Utilise la nouvelle méthode
        
        // Applique l'état sauvegardé
        GameState state = currentSave.recreateState();
        applyState(state);
        
        System.out.println("Game loaded successfully!");
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error loading the game: " + e.getMessage());
    }
    }

    private void applyState(GameState state) {
        // Apply player position
        player.setPlayerPosition(state.getPlayerPosition());

        // Apply visited locations
        for (String locName : state.getVisitedLocations()) {
            Location loc = findLocationByName(locName);
            if (loc != null) {
                loc.setVisited();
            }
        }

        // Apply unlocked locations
        for (String locName : state.getUnlockedLocations()) {
            Location loc = findLocationByName(locName);
            if (loc != null) {
                loc.unlockLocation();
            }
        }

        // Apply inventory
        player.getInventory().getItemList().clear();
        for (String itemName : state.getInventory()) {
            Item item = findItemByName(itemName);
            if (item != null) {
                player.getInventory().addItem(item);
            }
        }
    }

    private Location findLocationByName(String name) {
        for (int i = 0; i < worldMap.getXlength(); i++) {
            for (int j = 0; j < worldMap.getYlength(); j++) {
                Location loc = worldMap.getLocation(new int[] { i, j });
                if (loc != null && loc.getName().equals(name)) {
                    return loc;
                }
            }
        }
        return null;
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