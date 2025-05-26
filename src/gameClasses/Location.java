package gameClasses;

import java.util.ArrayList;

import utils.IPrintable;

public class Location implements IPrintable { // Est-ce que on doit implémenter ça du coup ?
    private String name;
    private String descr;
    private boolean isLocked;
    private ArrayList<Puzzle> puzzleList;
    private ArrayList<Item> itemList;

    public Location(String name, String descr, boolean isLocked) {
        this.descr = descr;
        this.isLocked = isLocked;
        this.name = name;
        this.puzzleList = new ArrayList<Puzzle>();
        this.itemList = new ArrayList<Item>();
    }

    public String getName() {
        return this.name;
    }

    public String getDescr() {
        return this.descr;
    }

    public boolean getIsLocked() {
        return this.isLocked;
    }

    public ArrayList<Puzzle> getPuzzleList() {
        return puzzleList;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public boolean dropPuzzle(Puzzle puzzle) {
        if (this.puzzleList.contains(puzzle)) {
            this.puzzleList.remove(puzzle);
            return true;
        } else {
            return false;
        }
    }

    public boolean dropItem(Item item) {
        if (this.itemList.contains(item)) {
            this.itemList.remove(item);
            return true;
        } else {
            return false;
        }
    }

    public boolean unlockLocation() {

        if (this.isLocked == true) {
            this.isLocked = false;
            return true;
        } else {
            return false;
        }
    }

    public boolean addItemToList(Item item) {
        if (this.itemList.contains(item)) {
            return false;
        } else {
            this.itemList.add(item);
            return true;
        }
    }

    public boolean addPuzzleToList(Puzzle puzzle) {
        if (this.puzzleList.contains(puzzle)) {
            return false;
        } else {
            this.puzzleList.add(puzzle);
            return true;
        }
    }

    @Override
    public String getPrintableString() {
        return name; // Affiche le nom complet de la location
    }

    @Override
    public boolean isGrayedOut() {
        return !this.isLocked;
    }

}