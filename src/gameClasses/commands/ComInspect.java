package gameClasses.commands;
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
        }
    } else {
        // Affiche l'inventaire numéroté
        for (int j = 0; j < getGame().getPlayer().getInventory().getItemList().size(); j++) {
            Item item = getGame().getPlayer().getInventory().getItemList().get(j);
            System.out.println((j + 1) + ". " + item.getName());
        }
    }
}
    private void displayItem(Item i){
        System.out.println("Inspecting " + i.getName());
        System.out.println("The item says " + '"' + i.inspect() + '"' + '.');
    }
}