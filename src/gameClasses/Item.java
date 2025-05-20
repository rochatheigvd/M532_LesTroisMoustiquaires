package gameClasses;

import gameClasses.interfaces.IInspectable;

public abstract class Item implements IInspectable {
    private String name;
    private String lookDescr;
    private String inspectDescr;

    Item(String name, String lookDescr, String inspectDescr) {
        this.name = name;
        this.lookDescr = lookDescr;
        this.inspectDescr = inspectDescr;
    }
}
