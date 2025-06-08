package gameClasses.commands;

import gameClasses.Command;
import java.io.*;

public class ComSave extends Command {
    private static final String SAVE_FILE = "game_save.dat";

    public ComSave(String verb, String description) {
        super(verb, description);
    }

    @Override
    public void execute(String argument) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE))) {
            oos.writeObject(getGame().getCurrentSave());
            System.out.println("Game saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving the game: " + e.getMessage());
        }
    }

    public static void deleteSave() {
        File saveFile = new File(SAVE_FILE);
        if (saveFile.exists()) {
            saveFile.delete();
        }
    }

    public static boolean saveExists() {
        return new File(SAVE_FILE).exists();
    }
}