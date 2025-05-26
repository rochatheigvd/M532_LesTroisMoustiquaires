package gameClasses.items;

import gameClasses.Command;
import gameClasses.Item;

public class Key extends Item {
    private int[] positionUnlockable;
    private int[] positionUsable;

    public Key(String name, String lookDescr, String inspectDescr, int[] positionUnlockable, int[] positionUsable) {
        super(name, lookDescr, inspectDescr);
        this.positionUnlockable = positionUnlockable;
        this.positionUsable = positionUsable;
    }

    public int[] getPositionUsable() {
        return positionUsable;
    }

    public int[] getPositionUnlockable() {
        return positionUnlockable;
    }

    @Override
    public String inspect() {
        return this.getInspectDescr() + " It is usable in "
                + Command.getGame().getWorldMap().getLocation(this.positionUsable).getName();
    }

}
