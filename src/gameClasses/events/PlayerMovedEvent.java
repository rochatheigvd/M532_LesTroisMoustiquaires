package gameClasses.events;

import gameClasses.GameState;

public class PlayerMovedEvent extends GameEvent {
    private final int[] newPosition;
    
    public PlayerMovedEvent(int[] position) {
        this.newPosition = position.clone();
    }
    
    @Override
    public void apply(GameState state) {
        state.setPlayerPosition(newPosition);
    }
}