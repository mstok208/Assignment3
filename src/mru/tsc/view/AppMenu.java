package mru.tsc.view;

import java.util.ArrayList;
import java.util.Scanner;

import mru.tsc.exceptions.InvalidPlayerCountException;
import mru.tsc.exceptions.NegativePriceException;
import mru.tsc.model.Toy;

public class AppMenu {
	
	
/**
	 * Handles all console user interface interactions, including displaying menus,
	 * collecting user input, and validating data formats.
	 * 
	 * @author Ali, Manmeet
	 */
	
    private Scanner input;

    /**
     *  Constructs a new AppMenu and initializes the console input scanner.
     */
	    
    public AppMenu() {
	        input = new Scanner(System.in);
	}

	    /**
	     * Displays the welcome banner when the application starts.
	     */
	    public void showWelcomeBanner() {
	        System.out.println("*****************************************************");
	       System.out.println("*         WELCOME TO TOY STORE COMPANY!             *");
	        System.out.println("*****************************************************\n");
	    }

	    /**
	     * Displays the main menu and validates that the user selects a valid option.
	     * 
	     * @return the validated main menu option selected by the user
	     */
	    public int showMainMenu() {
	        System.out.println("How We May Help You?\n");
	        System.out.println("(1) Search Inventory and Purchase Toy");
	        System.out.println("(2) Add New Toy");
	        System.out.println("(3) Remove Toy");
	        System.out.println("(4) Make a Gift Suggestion");
	        System.out.println("(5) Save & Exit\n");

	        return promptValidInt("Enter Option: ", 1, 5);
	    }

	    /**
	     * Displays the search sub menu and validates the user selection.
	     * 
	     * @return the validated search menu option selected by the user
	     */
	    public int showSearchMenu() {
	        System.out.println("\nFind Toys With:\n");
	        System.out.println("(1) Serial Number (SN)");
	        System.out.println("(2) Toy Name");
	        System.out.println("(3) Type");
	        System.out.println("(4) Back to Main Menu\n");

	        return promptValidInt("Enter Option: ", 1, 4);
	    }

	    /**
	     * Prompts the user to enter a valid integer within a specified range.
	     * Loops until valid integer input is provided.
	     * 
	     * @param prompt the message displayed to the user
	     * @param min    the minimum acceptable integer value
	     * @param max    the maximum acceptable integer value
	     * @return a validated integer within the given range
	     */
	    public int promptValidInt(String prompt, int min, int max) {
	        int value = -1;
	        boolean valid = false;

	        while (!valid) {
	            System.out.print(prompt);
	            String line = input.nextLine().trim();
	            try {
	                value = Integer.parseInt(line);
	                if (value >= min && value <= max) {
	                    valid = true;
	                } else {
	                    System.out.println("This is not a valid option! Try again.");
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("This is Not an Integer Number! Try again.");
	            }
	        }
	        return value;
	    }

	    /**
	     * Prompts the user to enter a valid 10 digit numeric serial number.
	     * 
	     * @return a validated 10 digit serial number string
	     */
	    public String promptValidSerialNumber() {
	        String sn = "";
	        boolean valid = false;

	        while (!valid) {
	            System.out.print("Enter Serial Number: ");
	            sn = input.nextLine().trim();

	            if (!sn.matches("\\d+")) {
	                System.out.println("The Serial Number should only contain digits! Try again.");
	            } else if (sn.length() != 10) {
	                System.out.println("The Serial Number's length MUST be 10 digits! Try again.");
	            } else {
	                valid = true;
	            }
	        }
	        return sn;
	    }

	    /**
	     * Displays an error message indicating that a serial number already exists.
	     */
	    public void showDuplicateSerialError() {
	        System.out.println("A Toy With This Serial Number Already Exists! Try Again.");
	    }

	    /**
	     * Prompts the user for a non empty string value.
	     * 
	     * @param prompt the message displayed to the user
	     * @return the trimmed non empty string entered by the user
	     */
	    public String promptNonEmptyString(String prompt) {
	        String text = "";
	        while (text.isEmpty()) {
	            System.out.print(prompt);
	            text = input.nextLine().trim();
	            if (text.isEmpty()) {
	                System.out.println("Input cannot be empty! Try again.");
	            }
	        }
	        return text;
	    }

	    /**
	     * Prompts the user for an optional string value that may be left blank.
	     * 
	     * @param prompt the message displayed to the user
	     * @return the trimmed string entered by the user, or empty string if skipped
	     */
	    public String promptOptionalString(String prompt) {
	        System.out.print(prompt);
	        return input.nextLine().trim();
	    }

	    /**
	     * Prompts the user for a toy price and throws a NegativePriceException if negative.
	     * 
	     * @return the validated non negative price
	     * @throws NegativePriceException if the entered price is less than zero
	     */
	    public double promptPrice() throws NegativePriceException {
	        while (true) {
	            System.out.print("Enter Toy Price: ");
	            String line = input.nextLine().trim();
	            try {
	                double price = Double.parseDouble(line);
	                if (price < 0) {
	                    throw new NegativePriceException();
	                }
	                return price;
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid price format! Please enter a numeric value.");
	            }
	        }
	    }

	    /**
	     * Prompts the user for a non negative integer count.
	     * 
	     * @param prompt the message displayed to the user
	     * @return a validated integer greater than or equal to zero
	     */
	    public int promptNonNegativeInt(String prompt) {
	        while (true) {
	            System.out.print(prompt);
	            String line = input.nextLine().trim();
	            try {
	                int count = Integer.parseInt(line);
	                if (count < 0) {
	                    System.out.println("Value cannot be negative! Try again.");
	                } else {
	                    return count;
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("This is Not an Integer Number! Try again.");
	            }
	        }
	    }

	    /**
	     * Prompts the user for minimum and maximum player counts for a board game.
	     * Throws an InvalidPlayerCountException if minimum exceeds maximum.
	     * 
	     * @return a two element integer array containing minimum players at index 0 and maximum players at index 1
	     * @throws InvalidPlayerCountException if minimum players is greater than maximum players
	     */
	    public int[] promptPlayerCounts() throws InvalidPlayerCountException {
	        int min = promptNonNegativeInt("Enter Minimum Number of Players: ");
	        int max = promptNonNegativeInt("Enter Maximum Number of Players: ");

	        if (min > max) {
	            throw new InvalidPlayerCountException();
	        }
	        return new int[] { min, max };
	    }

	    /**
	     * Prompts the user to enter a valid toy category type.
	     * 
	     * @return the validated toy type name
	     */
	    public String promptToyType() {
	        while (true) {
	            System.out.print("Enter Toy Type (Figure, Animal, Puzzle, BoardGame): ");
	            String type = input.nextLine().trim();
	            if (type.equalsIgnoreCase("Figure") || type.equalsIgnoreCase("Animal")
	                    || type.equalsIgnoreCase("Puzzle") || type.equalsIgnoreCase("BoardGame")
	                    || type.equalsIgnoreCase("Board Game")) {
	                return type;
	            }
	            System.out.println("Invalid toy type! Please enter Figure, Animal, Puzzle, or BoardGame.");
	        }
	    }

	    /**
	     * Prompts the user to enter a valid figure classification code.
	     * 
	     * @return the validated classification string
	     */
	    public String promptFigureClassification() {
	        while (true) {
	            System.out.print("Enter Figure Classification (Action, Doll, Historic): ");
	            String classification = input.nextLine().trim();
	            if (classification.equalsIgnoreCase("Action") || classification.equalsIgnoreCase("A")) {
	                return "A";
	            } else if (classification.equalsIgnoreCase("Doll") || classification.equalsIgnoreCase("D")) {
	                return "D";
	            } else if (classification.equalsIgnoreCase("Historic") || classification.equalsIgnoreCase("H")) {
	                return "H";
	            }
	            System.out.println("Invalid classification! Enter Action, Doll, or Historic.");
	        }
	    }

	    /**
	     * Prompts the user to enter a valid animal size code.
	     * 
	     * @return the validated size string
	     */
	    public String promptAnimalSize() {
	        while (true) {
	            System.out.print("Enter Animal Size (Small, Medium, Large): ");
	            String size = input.nextLine().trim();
	            if (size.equalsIgnoreCase("Small") || size.equalsIgnoreCase("S")) {
	                return "S";
	            } else if (size.equalsIgnoreCase("Medium") || size.equalsIgnoreCase("M")) {
	                return "M";
	            } else if (size.equalsIgnoreCase("Large") || size.equalsIgnoreCase("L")) {
	                return "L";
	            }
	            System.out.println("Invalid size! Enter Small, Medium, or Large.");
	        }
	    }

	    /**
	     * Prompts the user to enter a valid puzzle type.
	     * 
	     * @return the validated puzzle type string
	     */
	    public String promptPuzzleType() {
	        while (true) {
	            System.out.print("Enter Puzzle Type (Mechanical, Cryptic, Logic, Trivia, Riddle): ");
	            String type = input.nextLine().trim();
	            if (type.equalsIgnoreCase("Mechanical") || type.equalsIgnoreCase("Cryptic")
	                    || type.equalsIgnoreCase("Logic") || type.equalsIgnoreCase("Trivia")
	                    || type.equalsIgnoreCase("Riddle")) {
	                return type;
	            }
	            System.out.println("Invalid puzzle type! Enter Mechanical, Cryptic, Logic, Trivia, or Riddle.");
	        }
	    }

	    /**
	     * Displays a numbered list of search results and prompts the user to select an item to purchase.
	     * 
	     * @param results the list of matching Toy objects
	     * @return the chosen option index, where the last option returns to the previous menu
	     */
	    public int displaySearchResultsAndPromptPurchase(ArrayList<Toy> results) {
	        if (results.isEmpty()) {
	            System.out.println("\nNo matching toys found!");
	            return -1;
	        }

	        System.out.println("\nHere are the search results:\n");
	        for (int i = 0; i < results.size(); i++) {
	            System.out.printf("(%d) %s%n", i + 1, results.get(i).toString());
	        }
	        int backOption = results.size() + 1;
	        System.out.printf("(%d) Back To Search Menu%n%n", backOption);

	        return promptValidInt("Enter option number to purchase: ", 1, backOption);
	    }

	    /**
	     * Displays a single toy and asks the user to confirm removal.
	     * 
	     * @param toy the Toy object found for removal
	     * @return true if the user confirms removal with Y, false if N
	     */
	    public boolean confirmRemoval(Toy toy) {
	        System.out.println("\nThis Item Found:");
	        System.out.println(toy.toString());

	        while (true) {
	            System.out.print("Do you want to remove it (Y/N)? ");
	            String answer = input.nextLine().trim();
	            if (answer.equalsIgnoreCase("Y")) {
	                return true;
	            } else if (answer.equalsIgnoreCase("N")) {
	                return false;
	            }
	            System.out.println("Invalid input! Please enter Y or N.");
	        }
	    }

	    /**
	     * Displays a general informational or status message to the console.
	     * 
	     * @param message the message text to display
	     */
	    public void showMessage(String message) {
	        System.out.println(message);
	    }

	    /**
	     * Pauses console execution until the user presses the Enter key.
	     */
	    public void pressEnterToContinue() {
	        System.out.print("\nPress Enter to continue...");
	        input.nextLine();
	        System.out.println();
	    }

	    /**
	     * Displays the closing banner upon saving and exiting the application.
	     */
	    public void showExitBanner() {
	        System.out.println("Saving Data Into Database...");
	        System.out.println("Save and Exit!");
	        System.out.println("*********** THANKS FOR VISITING US! ***********");
	    }
	

}
