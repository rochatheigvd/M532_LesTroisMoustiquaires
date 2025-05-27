package gameClasses;

import utils.Info;
import java.util.ArrayList;

public class CommandRegistry {
    private ArrayList<Command> commandList;
    private Info in;

    public CommandRegistry() {
        this.commandList = new ArrayList<>();
        this.in = new Info();
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
            if (newStr[0].equals(Info.name())) {
                commandFound = true;
                if (newStr.length >= 2) {
                    in.create(newStr[1]);
                } else {
                    in.create(null);
                }
            } else {
                System.out.println("This command does not exist. Type help to see all the commands");
            }
        }
    }
}