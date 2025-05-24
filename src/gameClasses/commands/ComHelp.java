package gameClasses.commands;

import gameClasses.Command;
import gameClasses.CommandRegistry;

public class ComHelp extends Command {

    public ComHelp(String verb, String description) {
        super(verb, description);
    }

    @Override
    public void execute(String argument) {
        CommandRegistry registry = getGame().getCommandRegistry();
        System.out.println("Available commands:");
        for (Command cmd : registry.getCommandRegistry()) {
            System.out.println(cmd.getVerb() + " - " + cmd.getDescription());
        }
    }
}