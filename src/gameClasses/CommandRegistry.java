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
        int i = 0;
        boolean commandFind = false;
        do {
            Command command = this.commandList.get(i);
            if (command.getVerb().equals(newStr[0])) {
                commandFind = true;
                if (newStr.length >= 2) {
                    this.commandList.get(i).execute(newStr[1]);
                } else {
                    this.commandList.get(i).execute(null);
                }
            } else {
                i++;
            }
        } while (!commandFind || i < this.commandList.size());
        if (commandFind) {
            System.out.println("Commande inexistante");
        }
    }

}