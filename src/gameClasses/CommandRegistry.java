package gameClasses;

import java.util.ArrayList;

public class CommandRegistry {
    private ArrayList<Command> commandList;
}

public CommandRegistry() {
    commandList = new ArrayList<>();
}

public commandList getCommandRegistry() {
    return commandList;
}

public void addCommand(Command command) {
    commandList.add(command);
}

public void userInput(String){
    // Parse user input and execute the corresponding command
    String[] args = input.split(" ");
    String verb = args[0];
    for (Command command : commandList) {
        if (command.getVerb().equals(verb)) {
            command.execute(args);
            return;
        }
    }
    System.out.println("Unknown command: " + verb);
}
