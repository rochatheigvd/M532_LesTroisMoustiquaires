package gameClasses.events;

import java.io.Serializable;
import java.time.Instant;
import gameClasses.GameState;

public abstract class GameEvent implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Instant timestamp;
    
    public GameEvent() {
        this.timestamp = Instant.now();
    }
    
    public Instant getTimestamp() {
        return timestamp;
    }
    
    public abstract void apply(GameState state);
}