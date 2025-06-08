package gameClasses;

import java.io.Serializable;
import java.util.*;

public class GameState implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int[] playerPosition;
    private Set<String> unlockedLocations;
    private Set<String> visitedLocations;
    private List<String> inventory;
    private Set<String> solvedPuzzles;
    
    public GameState() {
        this.playerPosition = new int[]{1, 2}; 
        this.unlockedLocations = new HashSet<>();
        this.visitedLocations = new HashSet<>();
        this.inventory = new ArrayList<>();
        this.solvedPuzzles = new HashSet<>();
    }

    public void setPlayerPosition(int[] newPosition) {
        this.playerPosition = newPosition.clone();
    }

    public int[] getPlayerPosition() {
        return playerPosition.clone();
    }

    public Set<String> getUnlockedLocations() {
        return unlockedLocations;
    }

    public Set<String> getVisitedLocations() {
        return visitedLocations;
    }

    public List<String> getInventory() {
        return inventory;
    }

    public Set<String> getSolvedPuzzles() {
        return solvedPuzzles;
    }
}