package gameClasses;

import gameClasses.interfaces.ICommand;
import main.Game;

public abstract class Command implements ICommand {
    private String description;
    private String verb;
    private static Game game;
}

    public Command(String verb, String description) {
        this.verb = verb;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getVerb() {
        return verb;
    }

    public static Game getGame() {
        return game;
    }

    public static void setGame(Game game) {
        this.game = game;
    }

    public Location getPlayerLocation() {
        return Location;
    }

    public abstract void execute(String[] args);

}
