
package gameClasses;

import java.util.ArrayList;

public class Puzzle {
    private String solution;
    private ArrayList<Item> rewards;

    public Puzzle(String solution) {
        this.solution = solution;
        this.rewards = new ArrayList<>();
    }

    public String getSolution() {
        return solution;
    }

    public ArrayList<Item> getRewards() {
        return rewards;
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
