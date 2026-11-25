package mru.tsc.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import mru.tsc.exceptions.InvalidPlayerCountException;
import mru.tsc.exceptions.NegativePriceException;
import mru.tsc.model.Animal;
import mru.tsc.model.BoardGame;
import mru.tsc.model.Puzzle;
import mru.tsc.model.Toy;
import mru.tsc.model.figure;
import mru.tsc.view.AppMenu;

public class StoreManager {
	
	
	/**
	 * Controls the core business logic of the Toy Store Company application.
	 * Manages the inventory list, file input and output, search operations,
	 * purchasing, adding, removing, and gift suggestions.
	 * 
	 * @author Ali, Manmeet
	 */
	
	    private final String FILE_PATH = "res/toys.txt";
	    private ArrayList<Toy> toys;
	    private AppMenu appMenu;

	    /**
	     * Constructs a new StoreManager, initializes the toy inventory list and menu view,
	     * loads existing data from the database file, and launches the application loop.
	     */
	    public StoreManager() {
	        toys = new ArrayList<>();
	        appMenu = new AppMenu();
	        loadData();
	        launchApplication();
	    }

	    /**
	     * Reads toy records from the data file and populates the polymorphic toy list
	     * based on the first digit of each serial number.
	     */
	    public void loadData() {
	        File dbFile = new File(FILE_PATH);
	        if (!dbFile.exists()) {
	            appMenu.showMessage("Warning: Data file not found at " + FILE_PATH + ". Starting with empty inventory.");
	            return;
	        }

	        try (Scanner fileScanner = new Scanner(dbFile)) {
	            while (fileScanner.hasNextLine()) {
	                String line = fileScanner.nextLine().trim();
	                if (line.isEmpty()) {
	                    continue;
	                }

	                String[] parts = line.split(";");
	                String sn = parts[0].trim();
	                String name = parts[1].trim();
	                String brand = parts[2].trim();
	                double price = Double.parseDouble(parts[3].trim());
	                int availableCount = Integer.parseInt(parts[4].trim());
	                String ageAppropriate = parts[5].trim();

	                char firstDigit = sn.charAt(0);

	                if (firstDigit == '0' || firstDigit == '1') {
	                    String classification = parts[6].trim();
	                    toys.add(new figure(sn, name, brand, price, availableCount, ageAppropriate, classification));
	                } else if (firstDigit == '2' || firstDigit == '3') {
	                    String material = parts[6].trim();
	                    String size = parts[7].trim();
	                    toys.add(new Animal(sn, name, brand, price, availableCount, ageAppropriate, material, size));
	                } else if (firstDigit == '4' || firstDigit == '5' || firstDigit == '6') {
	                    String puzzleType = parts[6].trim();
	                    toys.add(new Puzzle(sn, name, brand, price, availableCount, ageAppropriate, puzzleType));
	                } else if (firstDigit == '7' || firstDigit == '8' || firstDigit == '9') {
	                    String[] playerRange = parts[6].trim().split("-");
	                    int minPlayers = Integer.parseInt(playerRange[0].trim());
	                    int maxPlayers = Integer.parseInt(playerRange[1].trim());
	                    String designers = parts[7].trim();
	                    toys.add(new BoardGame(sn, name, brand, price, availableCount, ageAppropriate, minPlayers, maxPlayers, designers));
	                }
	            }
	        } catch (FileNotFoundException e) {
	            appMenu.showMessage("Error loading file: " + e.getMessage());
	        }
	    }

	    /**
	     * Runs the main application loop until the user selects Save and Exit.
	     */
	    private void launchApplication() {
	        appMenu.showWelcomeBanner();
	        boolean running = true;

	        while (running) {
	            int option = appMenu.showMainMenu();
	            switch (option) {
	                case 1:
	                    searchAndPurchase();
	                    break;
	                case 2:
	                    addNewToy();
	                    break;
	                case 3:
	                    removeToy();
	                    break;
	                case 4:
	                    makeGiftSuggestion();
	                    break;
	                case 5:
	                    saveData();
	                    appMenu.showExitBanner();
	                    running = false;
	                    break;
	            }
	        }
	    }

	    /**
	     * Handles searching the inventory by serial number, name, or type,
	     * and allows the customer to purchase an available item.
	     */
	    private void searchAndPurchase() {
	        boolean inSearchMenu = true;

	        while (inSearchMenu) {
	            int searchOption = appMenu.showSearchMenu();
	            ArrayList<Toy> results = new ArrayList<>();

	            switch (searchOption) {
	                case 1:
	                    String sn = appMenu.promptValidSerialNumber();
	                    Toy foundBySn = findToyBySerialNumber(sn);
	                    if (foundBySn != null) {
	                        results.add(foundBySn);
	                    }
	                    break;
	                case 2:
	                    String nameQuery = appMenu.promptNonEmptyString("Enter Toy Name: ").toLowerCase();
	                    for (Toy toy : toys) {
	                        if (toy.getName().toLowerCase().contains(nameQuery)) {
	                            results.add(toy);
	                        }
	                    }
	                    break;
	                case 3:
	                    String typeQuery = appMenu.promptToyType();
	                    for (Toy toy : toys) {
	                        if (matchesToyType(toy, typeQuery)) {
	                            results.add(toy);
	                        }
	                    }
	                    break;
	                case 4:
	                    inSearchMenu = false;
	                    continue;
	            }

	            processPurchaseSelection(results);
	        }
	    }

	    /**
	     * Displays search results and processes the purchase of a selected toy.
	     * 
	     * @param results the list of matching toys to display
	     */
	    private void processPurchaseSelection(ArrayList<Toy> results) {
	        int choice = appMenu.displaySearchResultsAndPromptPurchase(results);
	        if (choice == -1) {
	            appMenu.pressEnterToContinue();
	            return;
	        }

	        if (choice <= results.size()) {
	            Toy selectedToy = results.get(choice - 1);
	            if (selectedToy.getAvailableCount() > 0) {
	                selectedToy.decrementCount();
	                appMenu.showMessage("\nThe Transaction Successfully Terminated!");
	            } else {
	                appMenu.showMessage("\nError: This item is currently out of stock!");
	            }
	            appMenu.pressEnterToContinue();
	        }
	    }

	    /**
	     * Guides the employee through adding a new toy to the inventory,
	     * validating uniqueness of the serial number and handling custom exceptions.
	     */
	    private void addNewToy() {
	        appMenu.showMessage("\nAdding a new Toy!");
	        String sn = "";
	        boolean unique = false;

	        while (!unique) {
	            sn = appMenu.promptValidSerialNumber();
	            if (findToyBySerialNumber(sn) != null) {
	                appMenu.showDuplicateSerialError();
	            } else {
	                unique = true;
	            }
	        }

	        String name = appMenu.promptNonEmptyString("Enter Toy Name: ");
	        String brand = appMenu.promptNonEmptyString("Enter Toy Brand: ");

	        double price = 0;
	        boolean validPrice = false;
	        while (!validPrice) {
	            try {
	                price = appMenu.promptPrice();
	                validPrice = true;
	            } catch (NegativePriceException e) {
	                appMenu.showMessage(e.getMessage() + " Try again.");
	            }
	        }

	        int availableCount = appMenu.promptNonNegativeInt("Enter Available Counts: ");
	        String ageAppropriate = appMenu.promptNonEmptyString("Enter Appropriate Age: ");

	        char firstDigit = sn.charAt(0);

	        if (firstDigit == '0' || firstDigit == '1') {
	            String classification = appMenu.promptFigureClassification();
	            toys.add(new figure(sn, name, brand, price, availableCount, ageAppropriate, classification));
	        } else if (firstDigit == '2' || firstDigit == '3') {
	            String material = appMenu.promptNonEmptyString("Enter Material: ");
	            String size = appMenu.promptAnimalSize();
	            toys.add(new Animal(sn, name, brand, price, availableCount, ageAppropriate, material, size));
	        } else if (firstDigit == '4' || firstDigit == '5' || firstDigit == '6') {
	            String puzzleType = appMenu.promptPuzzleType();
	            toys.add(new Puzzle(sn, name, brand, price, availableCount, ageAppropriate, puzzleType));
	        } else {
	            int[] playerCounts = null;
	            boolean validPlayers = false;
	            while (!validPlayers) {
	                try {
	                    playerCounts = appMenu.promptPlayerCounts();
	                    validPlayers = true;
	                } catch (InvalidPlayerCountException e) {
	                    appMenu.showMessage(e.getMessage() + " Try again.");
	                }
	            }
	            String designers = appMenu.promptNonEmptyString(
	                    "Enter Designer Names (Use ',' to separate the names if there is more than one name): ");
	            toys.add(new BoardGame(sn, name, brand, price, availableCount, ageAppropriate,
	                    playerCounts[0], playerCounts[1], designers));
	        }

	        appMenu.showMessage("New Toy Added!");
	        appMenu.pressEnterToContinue();
	    }

	    /**
	     * Prompts for a serial number, displays the matching toy, and removes it if confirmed.
	     */
	    private void removeToy() {
	        appMenu.showMessage("\nRemoving a Toy!");
	        String sn = appMenu.promptValidSerialNumber();
	        Toy toyToRemove = findToyBySerialNumber(sn);

	        if (toyToRemove == null) {
	            appMenu.showMessage("No toy found with Serial Number: " + sn);
	        } else if (appMenu.confirmRemoval(toyToRemove)) {
	            toys.remove(toyToRemove);
	            appMenu.showMessage("Item Removed!");
	        } else {
	            appMenu.showMessage("Removal Cancelled.");
	        }
	        appMenu.pressEnterToContinue();
	    }

	    /**
	     * Suggests gift options based on optional age, type, and price range criteria,
	     * and allows the customer to purchase one of the suggested items.
	     */
	    private void makeGiftSuggestion() {
	        appMenu.showMessage("\nGift Suggestion (Leave any option blank to skip):");
	        String ageInput = appMenu.promptOptionalString("Enter Appropriate Age (e.g., +5 or 5): ");
	        String typeInput = appMenu.promptOptionalString("Enter Toy Type (Figure, Animal, Puzzle, BoardGame): ");
	        String minPriceInput = appMenu.promptOptionalString("Enter Minimum Price: ");
	        String maxPriceInput = appMenu.promptOptionalString("Enter Maximum Price: ");

	        Double minPrice = parseOptionalDouble(minPriceInput);
	        Double maxPrice = parseOptionalDouble(maxPriceInput);

	        ArrayList<Toy> suggestions = new ArrayList<>();
	        for (Toy toy : toys) {
	            if (!ageInput.isEmpty() && !matchesAge(toy.getAgeAppropriate(), ageInput)) {
	                continue;
	            }
	            if (!typeInput.isEmpty() && !matchesToyType(toy, typeInput)) {
	                continue;
	            }
	            if (minPrice != null && toy.getPrice() < minPrice) {
	                continue;
	            }
	            if (maxPrice != null && toy.getPrice() > maxPrice) {
	                continue;
	            }
	            suggestions.add(toy);
	        }

	        processPurchaseSelection(suggestions);
	    }

	    /**
	     * Writes all toys in the inventory list back to the database text file in their required format.
	     */
	    public void saveData() {
	        try (PrintWriter writer = new PrintWriter(new File(FILE_PATH))) {
	            for (Toy toy : toys) {
	                writer.println(toy.format());
	            }
	        } catch (FileNotFoundException e) {
	            appMenu.showMessage("Error saving data to file: " + e.getMessage());
	        }
	    }

	    /**
	     * Searches the inventory list for a toy matching the exact serial number.
	     * 
	     * @param sn the 10 digit serial number to search for
	     * @return the matching Toy object, or null if not found
	     */
	    public Toy findToyBySerialNumber(String sn) {
	        for (Toy toy : toys) {
	            if (toy.getSerialNumber().equals(sn)) {
	                return toy;
	            }
	        }
	        return null;
	    }

	    /**
	     * Checks whether a given Toy instance matches the requested category type string.
	     * 
	     * @param toy      the Toy object to evaluate
	     * @param typeName the category string entered by the user
	     * @return true if the toy matches the specified type, false otherwise
	     */
	    private boolean matchesToyType(Toy toy, String typeName) {
	        String normalized = typeName.replace(" ", "").toLowerCase();
	        return toy.getClass().getSimpleName().toLowerCase().equals(normalized);
	    }

	    /**
	     * Compares a toy age rating with the user input age string.
	     * 
	     * @param toyAge   the age rating stored on the toy
	     * @param inputAge the age criteria entered by the user
	     * @return true if the age ratings match, false otherwise
	     */
	    private boolean matchesAge(String toyAge, String inputAge) {
	        String cleanToyAge = toyAge.replace("+", "").trim();
	        String cleanInputAge = inputAge.replace("+", "").trim();
	        return cleanToyAge.equalsIgnoreCase(cleanInputAge);
	    }

	    /**
	     * Safely parses an optional numeric string into a Double.
	     * 
	     * @param value the string input to parse
	     * @return the parsed Double value, or null if blank or invalid
	     */
	    private Double parseOptionalDouble(String value) {
	        if (value.isEmpty()) {
	            return null;
	        }
	        try {
	            return Double.parseDouble(value);
	        } catch (NumberFormatException e) {
	            return null;
	        }
	    }

	    /**
	     * Retrieves the full list of toys currently in inventory.
	     * 
	     * @return the ArrayList of Toy objects
	     */
	    public ArrayList<Toy> getToys() {
	        return toys;
	    }
	

}
