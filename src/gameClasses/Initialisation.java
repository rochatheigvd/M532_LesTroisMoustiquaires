package gameClasses;

public class Initialisation {
    
    public void initGame() {
        createInstances();
        linkInstances();
    }

    private void createInstances() {
        createItems();
        createPuzzles();
        createLocations();
        createWorldMap();
        createInventory();
        createPlayer();
        createCommandRegistry();
        createCommands();
        createGame();
    }

    private void createItems() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createItems'");
    }

    private void createPuzzles() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPuzzles'");
    }

    private void createLocations() {
        Location loc1 = new Location("Kitchen", "Ceci est le salon", true);
        Location loc2 = new Location("Dining Room", "Ceci est le salon", false);
        Location loc3 = new Location("Living Room", "Ceci est le salon", false);
        Location loc4 = new Location("Cagibi", "Ceci est le salon", true);
        Location loc5 = new Location("Toilet", "Ceci est le salon", true);
        Location loc6 = new Location("Hall Left", "Ceci est le salon", false);
        Location loc7 = new Location("Hall Right", "Ceci est le salon", false);
    }

    private void createWorldMap() {
        WorldMap worldMap = new WorldMap(3, 3);
    }

    private void createInventory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createInventory'");
    }

    private void createPlayer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPlayer'");
    }

    private void createCommandRegistry() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCommandRegistry'");
    }

    private void createCommands() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCommands'");
    }

    private void createGame() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createGame'");
    }

    private void linkInstances() {

    }
}