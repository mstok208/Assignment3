package mru.tsc.model;

public class BoardGame extends Toy{

	/**
	 * Represents a board game toy in the Toy Store Company inventory.
	 * Extends the abstract Toy class by adding minimum players, maximum players, and designers attributes.
	 * 
	 * @author Manmeet, Ali
	 */
	
	    private int minPlayers;
	    private int maxPlayers;
	    private String designers;

	    /**
	     * Constructs a new BoardGame object with all shared and board game specific attributes.
	     * 
	     * @param serialNumber   the unique 10 digit serial number starting with 7, 8, or 9
	     * @param name           the name of the board game
	     * @param brand          the brand or manufacturer of the board game
	     * @param price          the retail price of the board game
	     * @param availableCount the quantity currently available in stock
	     * @param ageAppropriate the recommended minimum age rating for the board game
	     * @param minPlayers     the minimum number of players required
	     * @param maxPlayers     the maximum number of players allowed
	     * @param designers      the designer or comma separated list of designers of the board game
	     */
	    public BoardGame(String serialNumber, String name, String brand, double price, int availableCount,
	                     String ageAppropriate, int minPlayers, int maxPlayers, String designers) {
	        super(serialNumber, name, brand, price, availableCount, ageAppropriate);
	        this.minPlayers = minPlayers;
	        this.maxPlayers = maxPlayers;
	        this.designers = designers;
	    }

	    /**
	     * Retrieves the minimum number of players required for the board game.
	     * 
	     * @return the minimum player count
	     */
	    public int getMinPlayers() {
	        return minPlayers;
	    }

	    /**
	     * Updates the minimum number of players required for the board game.
	     * 
	     * @param minPlayers the new minimum player count
	     */
	    public void setMinPlayers(int minPlayers) {
	        this.minPlayers = minPlayers;
	    }

	    /**
	     * Retrieves the maximum number of players allowed for the board game.
	     * 
	     * @return the maximum player count
	     */
	    public int getMaxPlayers() {
	        return maxPlayers;
	    }

	    /**
	     * Updates the maximum number of players allowed for the board game.
	     * 
	     * @param maxPlayers the new maximum player count
	     */
	    public void setMaxPlayers(int maxPlayers) {
	        this.maxPlayers = maxPlayers;
	    }

	    /**
	     * Retrieves the designer or designers of the board game.
	     * 
	     * @return the designers string
	     */
	    public String getDesigners() {
	        return designers;
	    }

	    /**
	     * Updates the designer or designers of the board game.
	     * 
	     * @param designers the new designers string
	     */
	    public void setDesigners(String designers) {
	        this.designers = designers;
	    }

	    /**
	     * Formats the board game attributes into a semicolon delimited string matching the
	     * structure required for saving to the inventory data file.
	     * 
	     * @return a formatted string representation for file storage
	     */
	    @Override
	    public String format() {
	        return String.format("%s;%s;%s;%.2f;%d;%s;%d-%d;%s",
	                getSerialNumber(), getName(), getBrand(), getPrice(), getAvailableCount(), getAgeAppropriate(),
	                minPlayers, maxPlayers, designers);
	    }

	    /**
	     * Returns a human readable string displaying all board game attributes.
	     * 
	     * @return a formatted string describing the board game
	     */
	    @Override
	    public String toString() {
	        return super.toString() + ", Min Players: " + minPlayers + ", Max Players: " + maxPlayers + ", Designers: " + designers;
	    }
	

}
