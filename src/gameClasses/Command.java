package gameClasses;

import gameClasses.interfaces.ICommand;
import main.Game;

public abstract class Command implements ICommand {
    private String description;
    private String verb;
    private static Game game;
<<<<<<< HEAD
=======

>>>>>>> Léa

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

<<<<<<< HEAD
    public static Game getGame() {
        return game;
    }

=======
>>>>>>> Léa
    public Location getPlayerLocation() {
        return Location;
    }

    public abstract void execute(String[] args);

}
