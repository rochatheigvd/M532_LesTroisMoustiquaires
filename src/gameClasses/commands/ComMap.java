package gameClasses.commands;

import gameClasses.*;
import utils.Array2Dprinter;
import utils.IPrintable;

public class ComMap extends Command {
    public ComMap(String verb, String description) {
        super(verb, description);
    }

    /*
     * J'ai implémenté l'interface de IPrintable dans Location. Je ne sais pas si
     * c'était juste...
     */
    @Override
    public void execute(String argument) {
        IPrintable[][] map = getGame().getWorldMap().getWorldMap();
        displayMap(map, getGame().getPlayer().getPlayerPosition());
    }

    private void displayMap(IPrintable[][] worldMap, int[] playerPosition) {
        String map = Array2Dprinter.print2DArray(worldMap, playerPosition[0], playerPosition[1]);
        System.out.println(map);
    }
}
