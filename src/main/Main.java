package main;

import gameClasses.Initialisation;
import gameClasses.commands.ComSave;
import utils.Color;
import utils.StringStyling;
import utils.Style;

public class Main {

    public static void main(String[] args) {

        System.out.println(StringStyling.StyleString("Starting...", Style.ITALIC, Color.BLACK));

        if (ComSave.saveExists()) {
            System.out.println("A save file was found. Do you want to:");
            System.out.println("1. Continue previous game");
            System.out.println("2. Start new game");
            
            try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
                String choice = scanner.nextLine().trim();
                
                if (choice.equals("1")) {
                    Game game = new Game();
                    game.loadGame();
                    game.run();
                } else {
                    ComSave.deleteSave();
                    startNewGame();
                }
            }
        } else {
            startNewGame();
        }

        System.out.println(StringStyling.StyleString("Terminating...", Style.ITALIC, Color.BLACK));
    }

    private static void startNewGame() {
        Initialisation initialisation = new Initialisation();
        initialisation.initGame();
        Game game = initialisation.getGame();
        game.run();
    }
}