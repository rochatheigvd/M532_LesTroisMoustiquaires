
package gameClasses;

import java.util.ArrayList;

public class Puzzle {
    private String solution;
    private ArrayList<Item> rewards;
    private String description;

    public Puzzle(String solution, String description) {
        this.solution = solution;
        this.rewards = new ArrayList<>();
        this.description = description;
    }

    public String getSolution() {
        return solution;
    }

    public ArrayList<Item> getRewards() {
        return rewards;
    }

    public String getDescrPuzzle(){
        return description;
    }

    public boolean addItemToRewards(Item item) {
        if (this.rewards.contains(item)) {
            return false;
        } else {
            this.rewards.add(item);
            return true;
        }
    }

}
