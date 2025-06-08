package gameClasses.events;

import gameClasses.GameState;

public class LocationUnlockedEvent extends GameEvent {
    private final String locationName;
    
    public LocationUnlockedEvent(String locationName) {
        this.locationName = locationName;
    }
    
    @Override
    public void apply(GameState state) {
        state.getUnlockedLocations().add(locationName);
    }
}