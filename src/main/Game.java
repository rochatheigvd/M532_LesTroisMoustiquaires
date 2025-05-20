package main;

import gameClasses.CommandRegistry;
import gameClasses.Player;
import gameClasses.WorldMap;

public class Game {
    Player player;
    WorldMap worldMap;
    CommandRegistry commandRegistry;

    public Game(Player player,WorldMap worldMap,CommandRegistry commandRegistry) {
        this.player = player;
        this.worldMap = worldMap;
        this.commandRegistry = commandRegistry;
        System.out.println("Initializing game...");
    }

    public void run() {
        System.out.println("Running game...");
        // your runtime code here...

        // end of game
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
    public void setPlayer(player) {
        this.player = player;
    }
    public void setWorldMap(worldMap) {
        this.worldMap = worldMap;
    }
    public void setCommandRegistry(commandRegistry) {
        this.commandRegistry = commandRegistry;
    }

}