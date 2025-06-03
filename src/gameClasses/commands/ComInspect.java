package gameClasses.commands;
<<<<<<< HEAD

import java.util.List;

=======
>>>>>>> Léa
import gameClasses.Command;
import gameClasses.Item;

public class ComInspect extends Command {

    public ComInspect(String verb, String description) {
        super(verb, description);
    }

    @Override
public void execute(String argument) {
    if (argument != null) {
        // Vérifie si l'argument est un nombre
        try {
            int index = Integer.parseInt(argument);
            if (index >= 1 && index <= getGame().getPlayer().getInventory().getItemList().size()) {
                Item selectedItem = getGame().getPlayer().getInventory().getItemList().get(index - 1);
                displayItem(selectedItem);
            } else {
                System.out.println("Numéro d'item invalide.");
            }
        } catch (NumberFormatException e) {
            // Si ce n'est pas un nombre, on cherche par nom
            Item i = getGame().getPlayer().getInventory().getItem(argument);
            if (i != null) {
                displayItem(i);
            } else {
                System.out.println("Cet item n'existe pas dans votre inventaire.");
            }
<<<<<<< HEAD
        } else {
            List<Item> i = getGame().getPlayer().getInventory().getItemList();
            if (i.size() > 0) {
                for (int j = 0; j < i.size(); j++) {
                    System.out.println("(" + (j + 1) + ") " + i.get(j).getName());
                }
                System.out.println("Which item do you want to inspect?");
                int input = -1;

                java.util.Scanner scanner = new java.util.Scanner(System.in);
                do {
                    while (!scanner.hasNextInt()) {
                        System.out.print("Ce n'est pas un entier. Réessayez : ");
                        scanner.next();
                    }
                    input = scanner.nextInt();
                    if (input < 1 || input > i.size()) {
                        if (i.size() > 1) {
                            System.out.println("The number must be between " + 1 + " and " + i.size() + ".");
                        } else {
                            System.out.println("The number must be 1");
                        }

                    }
                } while (input < 1 || input > i.size());

                if (input != -1) {
                    displayItem(i.get(input - 1));
                }
            } else {
                System.out.println("There is nothing in your inventory.");
            }
=======
        }
    } else {
        // Affiche l'inventaire numéroté
        for (int j = 0; j < getGame().getPlayer().getInventory().getItemList().size(); j++) {
            Item item = getGame().getPlayer().getInventory().getItemList().get(j);
            System.out.println((j + 1) + ". " + item.getName());
>>>>>>> Léa
        }
    }
}
    private void displayItem(Item i){
        System.out.println("Inspecting " + i.getName());
        System.out.println("The item says " + '"' + i.inspect() + '"' + '.');
    }
}