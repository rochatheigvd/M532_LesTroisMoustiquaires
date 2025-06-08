package gameClasses;

import gameClasses.events.GameEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Save implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<GameEvent> events;
    
    public Save() {
        this.events = new ArrayList<>();
    }
    
    public void addEvent(GameEvent event) {
        events.add(event);
    }
    
    public GameState recreateState() {
        GameState state = new GameState();
        for (GameEvent event : events) {
            event.apply(state);
        }
        return state;
    }
}