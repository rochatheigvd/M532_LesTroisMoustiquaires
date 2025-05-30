package gameClasses;

public class WorldMap {
    private Location[][] worldMap;

    public WorldMap(int xSize, int ySize) {
        this.worldMap = new Location[xSize][ySize];
    }

    public Location getLocation(int[] position) {
        if (position[0] < this.worldMap.length && position[0] >= 0 && position[1] < this.worldMap[0].length
                && position[1] >= 0) {
            return this.worldMap[position[0]][position[1]];
        } else {
            return null;
        }
    }

    public Location[][] getWorldMap() {
        return this.worldMap;
    }

    public boolean setWorldMap(Location location, int[] locPos) {
        if (locPos[0] < this.worldMap.length && locPos[0] >= 0 && locPos[1] < this.worldMap[0].length && locPos[1] >= 0
                && location != null) {
            this.worldMap[locPos[0]][locPos[1]] = location;
            return true;
        } else {
            return false;
        }
    }

    public int getXlength() {
        return this.worldMap.length;
    }

    public int getYlength() {
        return this.worldMap[0].length;
    }
}