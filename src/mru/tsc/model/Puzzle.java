package mru.tsc.model;

public class Puzzle extends Toy {
	
	/**
	 * Represents a puzzle toy in the Toy Store Company inventory.
	 * Extends the abstract Toy class by adding the specific puzzle type attribute.
	 * 
	 * @author Ali, Manmeet
	 */
	
	    private String puzzleType;

	    /**
	     * Constructs a new Puzzle object with all shared and puzzle specific attributes.
	     * 
	     * @param serialNumber   the unique 10 digit serial number starting with 4, 5, or 6
	     * @param name           the name of the puzzle
	     * @param brand          the brand or manufacturer of the puzzle
	     * @param price          the retail price of the puzzle
	     * @param availableCount the quantity currently available in stock
	     * @param ageAppropriate the recommended minimum age rating for the puzzle
	     * @param puzzleType     the category of puzzle such as Mechanical, Cryptic, Logic, Trivia, or Riddle
	     */
	    public Puzzle(String serialNumber, String name, String brand, double price, int availableCount,
	                  String ageAppropriate, String puzzleType) {
	        super(serialNumber, name, brand, price, availableCount, ageAppropriate);
	        this.puzzleType = puzzleType;
	    }

	    /**
	     * Retrieves the specific type of the puzzle.
	     * 
	     * @return the puzzle type
	     */
	    public String getPuzzleType() {
	        return puzzleType;
	    }

	    /**
	     * Updates the specific type of the puzzle.
	     * 
	     * @param puzzleType the new puzzle type
	     */
	    public void setPuzzleType(String puzzleType) {
	        this.puzzleType = puzzleType;
	    }

	    /**
	     * Formats the puzzle attributes into a semicolon delimited string matching the
	     * structure required for saving to the inventory data file.
	     * 
	     * @return a formatted string representation for file storage
	     */
	    @Override
	    public String format() {
	        return String.format("%s;%s;%s;%.2f;%d;%s;%s",
	                getSerialNumber(), getName(), getBrand(), getPrice(), getAvailableCount(), getAgeAppropriate(), puzzleType);
	    }

	    /**
	     * Returns a human readable string displaying all puzzle attributes.
	     * 
	     * @return a formatted string describing the puzzle
	     */
	    @Override
	    public String toString() {
	        return super.toString() + ", Puzzle Type: " + puzzleType;
	    }
	

}
