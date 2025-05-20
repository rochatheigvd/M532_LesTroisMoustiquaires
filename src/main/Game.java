package main;

import gameClasses.CommandRegistry;
import gameClasses.Player;
import gameClasses.WorldMap;

public class Game {
    Player player;
    WorldMap worldMap;
    CommandRegistry commandRegistry;

    public Game(player, worldMap, commandRegistry) {
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

    getPlayer() {
        return player;
    }
    getWorldMap() {
        return worldMap;
    }
    getCommandRegistry() {
        return commandRegistry;
    }
    setPlayer(player) {
        this.player = player;
    }
    setWorldMap(worldMap) {
        this.worldMap = worldMap;
    }
    setCommandRegistry(commandRegistry) {
        this.commandRegistry = commandRegistry;
    }

}