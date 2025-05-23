package gameClasses.items;

import gameClasses.Item;

public class Letter extends Item {

    public Letter(String name, String lookDescr, String inspectDescr) {
        super(name, lookDescr, inspectDescr);
    }

    @Override
    public String inspect() {
        return this.getInspectDescr();
    }
}
