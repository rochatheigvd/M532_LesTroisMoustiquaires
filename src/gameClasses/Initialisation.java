package gameClasses;

import java.util.HashMap;
import java.util.Map;
import gameClasses.items.Key;
import main.Game;
import gameClasses.items.Letter;

public class Initialisation {

    private Game game;
    private WorldMap worldMap;
    private Player player;
    private Inventory inventory;
    private CommandRegistry commandRegistry;
    private Map<String, Location> locations = new HashMap<>();
    private Map<String, Command> commands = new HashMap<>();
    private Map<String, Key> keys = new HashMap<>();
    private Map<String, Puzzle> puzzles = new HashMap<>();
    private Map<String, Letter> letters = new HashMap<>();

    public void initGame() {
        createInstances();
        linkInstances();
        Command.setGame(game);
    }

    private void createInstances() {
        createItems();
        createPuzzles();
        createLocations();
        createWorldMap();
        createInventory();
        createPlayer();
        createCommandRegistry();
        createCommands();
        createGame();
    }

    private void createItems() {
        // Key for Kitchen (locked)
        keys.put("Kitchen_Key", new gameClasses.items.Key(
            "Kitchen_Key",
            "A shiny brass key labeled 'Kitchen'.",
            "This key unlocks the kitchen door.",
            new int[] { 0, 0 },
            new int[] { 1, 0 }));

        // Key for Storage Closet (locked)
        keys.put("Storage_Closet_Key", new gameClasses.items.Key(
            "Storage_Closet_Key",
            "A small, rusty key with a tag that reads 'Storage Closet'.",
            "This key unlocks the storage closet.",
            new int[] { 2, 1 },
            new int[] { 1, 1 }));

        // Key for Toilet (locked)
        keys.put("Toilet_Key", new gameClasses.items.Key(
            "Toilet_Key",
            "A simple silver key with a blue ribbon.",
            "This key unlocks the bathroom.",
            new int[] { 0, 2 },
            new int[] { 1, 2 }));

        //Letter for Hall Left
        letters.put("Letter_1", new gameClasses.items.Letter(
            "old_letter",
            "A beautifully written old letter",
            "What object is used to clean the floor but never gets dirty? You will need it in the room with many doors."
        ));

        //Letter for ?
        letters.put("Letter_2", new gameClasses.items.Letter(
            "mysterious_letter",
            "A mysterious note",
            "What flows but never runs out? Solve this where you usually eat."
        ));

        //Letter for ?
        letters.put("Letter_3", new gameClasses.items.Letter(
            "cryptic_letter",
            "A cryptic message",
            "What fruit is red and often found in kitchens? Solve this where the facade are faded."
        ));


    }

    private void createPuzzles() {
        // Puzzle for Kitchen Key
        puzzles.put("Hall Right", new Puzzle(
            "broom",
            "Find the hidden cleaning tool to get the Storage Closet Key."));

        // Storage Closet puzzle gives Toilet Key
        puzzles.put("Storage Closet", new Puzzle(
            "water",
            "Answer the question about what flows but never runs out to get the Toilet Key."));

        // Toilet puzzle gives Kitchen Key
        puzzles.put("Toilet", new Puzzle(
            "apple",
            "Solve the riddle about fruit to get the Kitchen Key."));
    }

    private void createLocations() {
        locations.put("Kitchen", new Location("Kitchen", "A tidy kitchen filled with the aroma of fresh herbs and the clatter of cookware. Sunlight streams in through a small window.", true));
        locations.put("Dining Room", new Location("Dining Room", "A formal dining room with a long wooden table, elegant chairs, and a chandelier hanging above. The scent of old wood lingers in the air.", false));
        locations.put("Living Room", new Location("Living Room", "A cozy living room with plush sofas, a crackling fireplace, and shelves lined with books and family photos.", false));
        locations.put("Storage Closet", new Location("Storage Closet", "A cramped storage closet cluttered with cleaning supplies, old boxes, and forgotten tools.", true));
        locations.put("Toilet", new Location("Toilet", "A small, clean bathroom with tiled walls, a simple sink, and a faint scent of lavender soap.", true));
        locations.put("Hall Left", new Location("Hall Left", "A narrow hallway with creaky floorboards and faded wallpaper, leading to other parts of the house.", false));
        locations.put("Hall Right", new Location("Hall Right", "A bright corridor with several doors and a window at the end, letting in the afternoon light.", false));
    }

    private void createWorldMap() {
        worldMap = new WorldMap(3, 3);
    }

    private void createInventory() {
        inventory = new Inventory();
    }

    private void createPlayer() {
        player = new Player();
    }

    private void createCommandRegistry() {
        commandRegistry = new CommandRegistry();
    }

    private void createCommands() {
        commands.put("help", new gameClasses.commands.ComHelp("help", "Show available commands"));
        commands.put("look", new gameClasses.commands.ComLook("look", "Look around in the current location"));
        commands.put("inspect", new gameClasses.commands.ComInspect("inspect", "Inspect an item from your inventory"));
        commands.put("move", new gameClasses.commands.ComMove("move", "Move to an unlocked adjacent location (north, east, south, west)"));
        commands.put("take", new gameClasses.commands.ComTake("take", "Pick up an item from the current location"));
        commands.put("inventory", new gameClasses.commands.ComInventory("inventory", "Show your inventory"));
        commands.put("use", new gameClasses.commands.ComUse("use", "Use an item from your inventory"));
        commands.put("map", new gameClasses.commands.ComMap("map", "Show the world map and your current location"));
        commands.put("say", new gameClasses.commands.ComSay("say", "Say something to solve a puzzle"));
    }

    private void createGame() {
        game = new main.Game();
    }

    private void linkInstances() {
        linkItemsToRewards();
        linkItemsToLocations();
        linkPuzzles();
        linkLocations();
        linkWorldMap();
        linkInventory();
        linkPlayer();
        linkCommandRegistry();
        linkCommands();
    }

    private void linkItemsToLocations() {
        locations.get("Hall Left").addItemToList(letters.get("Letter_1"));
        locations.get("Storage Closet").addItemToList(letters.get("Letter_2"));
        locations.get("Kitchen").addItemToList(letters.get("Letter_3"));
    }

    private void linkItemsToRewards() {
        puzzles.get("Hall Right").addItemToRewards(keys.get("Storage_Closet_Key"));
        puzzles.get("Storage Closet").addItemToRewards(keys.get("Toilet_Key"));
        puzzles.get("Toilet").addItemToRewards(keys.get("Kitchen_Key"));
    }

    private void linkPuzzles() {
        locations.get("Hall Right").addPuzzleToList(puzzles.get("Hall Right"));
        locations.get("Storage Closet").addPuzzleToList(puzzles.get("Storage Closet"));
        locations.get("Toilet").addPuzzleToList(puzzles.get("Toilet"));
    }

    private void linkLocations() {
        // Insert locations into the worldMap
        worldMap.setWorldMap(locations.get("Kitchen"),        new int[] { 0, 0 });
        worldMap.setWorldMap(locations.get("Dining Room"),    new int[] { 1, 0 });
        worldMap.setWorldMap(locations.get("Living Room"),    new int[] { 1, 1 });
        worldMap.setWorldMap(locations.get("Storage Closet"), new int[] { 2, 1 });
        worldMap.setWorldMap(locations.get("Toilet"),         new int[] { 0, 2 });
        worldMap.setWorldMap(locations.get("Hall Left"),      new int[] { 1, 2 });
        worldMap.setWorldMap(locations.get("Hall Right"),     new int[] { 2, 2 });
    }

    private void linkWorldMap() {
        // Link the worldMap to the game instance
        game.setWorldMap(worldMap);
    }

    private void linkInventory() {
        // Link the worldMap to the game instance
        player.setInventory(inventory);
    }

    private void linkPlayer() {
        // Set player's starting position
        player.setPlayerPosition(new int[] {1, 2});
        // Link the player to the game instance
        game.setPlayer(player);
    }

    private void linkCommandRegistry() {
        // Link the commandRegistry to the game instance
        game.setCommandRegistry(commandRegistry);
    }

    private void linkCommands() {
        for (Command cmd : commands.values()) {
            commandRegistry.addCommand(cmd);
        }
    }

    public Game getGame() {
        return this.game;
    }
}