package mru.tsc.model;

public class figure extends Toy{

	/**
	 * Represents a figure toy in the Toy Store Company inventory.
	 * Extends the abstract Toy class by adding the classification attribute.
	 * 
	 * @author Manmeet, Ali
	 */
	
	    private String classification;

	    /**
	     * Constructs a new Figure object with all shared and figure specific attributes.
	     * 
	     * @param serialNumber   the unique 10 digit serial number starting with 0 or 1
	     * @param name           the name of the figure
	     * @param brand          the brand or manufacturer of the figure
	     * @param price          the retail price of the figure
	     * @param availableCount the quantity currently available in stock
	     * @param ageAppropriate the recommended minimum age rating for the figure
	     * @param classification the category of the figure such as Action, Doll, or Historic
	     */
	    public figure(String serialNumber, String name, String brand, double price, int availableCount,
	                  String ageAppropriate, String classification) {
	        super(serialNumber, name, brand, price, availableCount, ageAppropriate);
	        this.classification = classification;
	    }

	  

		/**
	     * Retrieves the classification of the figure.
	     * 
	     * @return the figure classification
	     */
	    public String getClassification() {
	        return classification;
	    }

	    /**
	     * Updates the classification of the figure.
	     * 
	     * @param classification the new figure classification
	     */
	    public void setClassification(String classification) {
	        this.classification = classification;
	    }

	    /**
	     * Formats the figure attributes into a semicolon delimited string matching the
	     * structure required for saving to the inventory data file.
	     * 
	     * @return a formatted string representation for file storage
	     */
	    @Override
	    public String format() {
	        return String.format("%s;%s;%s;%.2f;%d;%s;%s",
	                getSerialNumber(), getName(), getBrand(), getPrice(), getAvailableCount(), getAgeAppropriate(), classification);
	    }

	    /**
	     * Returns a human readable string displaying all figure attributes.
	     * 
	     * @return a formatted string describing the figure
	     */
	    @Override
	    public String toString() {
	        return super.toString() + ", Classification: " + classification;
	    }
	

}
