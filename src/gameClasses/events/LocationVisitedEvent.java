package gameClasses.events;

import gameClasses.GameState;

public class LocationVisitedEvent extends GameEvent {
    private final String locationName;
    
    public LocationVisitedEvent(String locationName) {
        this.locationName = locationName;
    }
    
    @Override
    public void apply(GameState state) {
        state.getVisitedLocations().add(locationName);
    }
}