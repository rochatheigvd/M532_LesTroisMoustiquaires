package utils;

import java.util.ArrayList;
import java.util.Iterator;
import gameClasses.Command;
import gameClasses.Item;
import gameClasses.Location;
import gameClasses.Puzzle;
import gameClasses.items.Letter;

public class Info extends Command {
    int count;
    static String name = "bernardo";

    private void dance() {
        System.out.println("Au revoir hahaha");
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        System.exit(0);
    }

    private void pause() {
        System.out.println("Ton superpouvoir est de faire une pause de 10mn. (600 secondes)");
        for (int i = 0; i < 600; i++) {
            System.out.println((i + 1) + "s");
            try {
                Thread.sleep(1 * 999);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("FIN DE LA PAUSE !!!");
    }

    private void finishGame() {
        Location[][] worldMap = getGame().getWorldMap().getWorldMap();
        for (Location[] locations : worldMap) {
            for (Location location : locations) {
                if (location != null) {
                    location.unlockLocation();
                    ArrayList<Puzzle> puzzles = location.getPuzzleList();
                    if (!puzzles.isEmpty()) {
                        Iterator<Puzzle> it = puzzles.iterator();
                        while (it.hasNext()) {
                            Puzzle p = it.next();
                            ArrayList<Item> items = p.getRewards();
                            if (!items.isEmpty()) {
                                for (Item item : items) {
                                    getGame().getPlayer().getInventory().addItem(item);
                                }
                            }
                            it.remove();
                        }
                    }
                    ArrayList<Item> items = location.getItemList();
                    if (!items.isEmpty()) {
                        Iterator<Item> itI = items.iterator();
                        while (itI.hasNext()) {
                            Item i = itI.next();
                            getGame().getPlayer().getInventory().addItem(i);
                        }
                        itI.remove();
                    }
                }
            }
        }
        System.out.println("Toutes les locations ont été ouvertes par Bernardo et il t'a donné tous les items.");
        System.out.println("Voici la nouvelle carte:");
        ArrayList<Command> commandsList = getGame().getCommandRegistry().getCommandRegistry();
        for (Command command : commandsList) {
            if (command.getVerb().toLowerCase().equals("map")) {
                command.execute(null);
                break;
            }

        }
        System.out.println("Voici ton nouvel inventaire:");
        for (Command command : commandsList) {
            if (command.getVerb().toLowerCase().equals("inventory")) {
                command.execute(null);
                break;
            }
        }
    }

    public Info() {
        super("bernardo", null);
        this.count = 0;
    }

    @Override
    public void execute(String argument) {
    }

    private void escargot() {
        Letter lettre = new Letter("Bernardo_Letter", "Une lettre de Bernardo l'escargot",
                "Merci de m'avoir aidé à sortir de ma coquille et être devenu une limace. J'espère qu'on se reverra. Bernardo");
        System.out.println("You win : Bernardo_Letter");
        Command.getGame().getPlayer().getInventory().addItem(lettre);
    }

    private void afficherCommands() {
        System.out.println("break : te donne un superpouvoir");
        System.out.println("l'escargot : tu gagnes un nouvel item dans l'inventaire.");
        System.out.println("???? : øƒ∂∆µ≤≥÷åß∫œ∑´®†¥¨ˆπ“‘«»¬…æ╬▒░▓█■▀▄ (NE PAS UTILISER)");
    }

    public static String name() {
        return name;
    }

    public void create(String argument) {
        if (this.count > 0) {
            if (this.count <= 2) {
                if (argument != null) {
                    switch (argument) {
                        case "help":
                            afficherCommands();
                            break;
                        case "l'escargot":
                            escargot();
                            break;
                        case "break":
                            pause();
                            break;
                        case "????":
                            dance();
                            break;
                        case "win":
                            finishGame();
                            break;
                        default:
                            System.out.println(
                                    "HAHAHAHAHAHAHAH! TROP NUL, TU PENSAIS VRAIMENT QUE J'ACCEPTERAIS DES ARGUMENTS RANDOMS ??? xD");
                            break;
                    }
                } else {
                    System.out.println("Il n'y a pas d'argument dans ta commande, tu as presque tué Bernardo");
                }
            } else if (count == 3) {
                System.out.println("Tu as écrasé bernardo, il est mort.");
            } else {
                System.out.println("Bernardo est mort. Tu l'avais écrasé, tu te souviens ?");
            }

        } else {
            System.out.println("Bonjour, je suis Bernardo l'escargot.");
            int secondsToSleep = 1;
            try {
                Thread.sleep(secondsToSleep * 1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Je peux enfin sortir de ma coquille...");
            try {
                Thread.sleep(secondsToSleep * 1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Merci de m'avoir trouvé! ;)");
            try {
                Thread.sleep(secondsToSleep * 1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Comment puis-je vous aidez ?");
        }
        this.count = count + 1;
    }
}
