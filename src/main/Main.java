package main;

import gameClasses.Initialisation;
import utils.Color;
import utils.StringStyling;
import utils.Style;

public class Main {

    public static void main(String[] args) {

        System.out.println(StringStyling.StyleString("Starting...", Style.ITALIC, Color.BLACK));

        Initialisation initialisation = new Initialisation();
        initialisation.initGame();

        Game game = initialisation.getGame();
        game.run();

        System.out.println(StringStyling.StyleString("Terminating...", Style.ITALIC, Color.BLACK));
    }
}