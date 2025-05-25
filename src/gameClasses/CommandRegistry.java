package gameClasses;

import java.util.ArrayList;

public class CommandRegistry {
    private ArrayList<Command> commandList;

    public CommandRegistry() {
        this.commandList = new ArrayList<>();
    }

    public ArrayList<Command> getCommandRegistry() {
        return this.commandList;
    }

    public boolean addCommand(Command command) {
        if (this.commandList.contains(command)) {
            return false;
        } else {
            this.commandList.add(command);
            return true;
        }
    }

    public void userInput(String input) {
        input = input.toLowerCase();
        String[] newStr = input.split(" ");
        boolean commandFound = false;
        for (Command command : this.commandList) {
            if (command.getVerb().equals(newStr[0])) {
                commandFound = true;
                if (newStr.length >= 2) {
                    command.execute(newStr[1]);
                } else {
                    command.execute(null);
                }
                break;
            }
        }
        if (!commandFound) {
            System.out.println("This command does not exist. Type help to see all the commands");
        }
    }

}