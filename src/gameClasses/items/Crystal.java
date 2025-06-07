package gameClasses.items;

import gameClasses.Item;

public class Crystal extends Item {

    public Crystal(String name, String lookDescr, String inspectDescr) {
        super(name, lookDescr, inspectDescr);
    }

    @Override
    public String inspect() {
        return this.getInspectDescr();
    }

}
