package gameClasses;

public class WorldMap {
    private Location[][] worldMap;

    public WorldMap() {
        this.worldMap = new Location[3][3];
    }

    public Location getLocation(int[] position) {
        if (position[0] < 3 && position[0] >= 0 && position[1] < 3 && position[1] >= 0) {
            return this.worldMap[position[0]][position[1]];
        } else {
            return null;
        }
    }

    public Location[][] getWorldMap() {
        return this.worldMap;
    }

    public boolean setWorldMap(Location location, int[] locPos) {
        if (locPos[0] < 3 && locPos[0] >= 0 && locPos[1] < 3 && locPos[1] >= 0 && location != null) {
            if (this.worldMap[locPos[0]][locPos[1]] != null) {
                this.worldMap[locPos[0]][locPos[1]] = location;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
