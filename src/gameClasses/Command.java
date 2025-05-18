package gameClasses;

import gameClasses.interfaces.ICommand;
import main.Game;

public abstract class Command implements ICommand {
    private String description;
    private String verb;
    private static Game game;
}
