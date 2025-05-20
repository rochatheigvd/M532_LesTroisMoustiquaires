package gameClasses;

public class Player {
    private int[] playerPosition;
    private Inventory inventory;

    public Player() {
        this.playerPosition = new int[2];
        this.inventory = null;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setPlayerPosition(int[] position) {
        this.playerPosition = position;
    }

    public int[] getPlayerPosition() {
        return this.playerPosition;
    }
}
