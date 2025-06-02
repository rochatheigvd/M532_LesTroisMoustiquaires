package gameClasses.items;

import java.util.ArrayList;
import java.util.List;

import gameClasses.Command;
import gameClasses.Item;

public class Key extends Item {
    private List<int[]> positionUnlockable;
    private int[] positionUsable;

    public Key(String name, String lookDescr, String inspectDescr, int[] positionUsable) {
        super(name, lookDescr, inspectDescr);
        this.positionUnlockable = new ArrayList<>();
        this.positionUsable = positionUsable;
    }

    public void addPositionUnlockable(int[] position) {
        positionUnlockable.add(position);
    }

    public int[] getPositionUsable() {
        return positionUsable;
    }

    public List<int[]> getPositionUnlockable() {
        return positionUnlockable;
    }

    @Override
    public String inspect() {
        return this.getInspectDescr() + " It is usable in "
                + Command.getGame().getWorldMap().getLocation(this.positionUsable).getName();
    }

}
