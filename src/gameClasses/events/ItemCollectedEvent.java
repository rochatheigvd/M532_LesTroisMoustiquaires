package gameClasses.events;

import gameClasses.GameState;

public class ItemCollectedEvent extends GameEvent {
    private final String itemName;
    
    public ItemCollectedEvent(String itemName) {
        this.itemName = itemName;
    }
    
    @Override
    public void apply(GameState state) {
        state.getInventory().add(itemName);
    }
}