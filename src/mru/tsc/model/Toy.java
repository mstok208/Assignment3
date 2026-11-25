package mru.tsc.model;

public abstract class Toy {
	
	/**
	 * Represents an abstract base class for all toys in the Toy Store Company inventory.
	 * Contains the shared attributes and common behaviors inherited by all specific toy types.
	 * 
	 * @author Manmeet, Ali
	 */
	
	    private String serialNumber;
	    private String name;
	    private String brand;
	    private double price;
	    private int availableCount;
	    private String ageAppropriate;

	    /**
	     * Constructs a new Toy with the specified common attributes.
	     * 
	     * @param serialNumber   the unique 10 digit serial number of the toy
	     * @param name           the name of the toy
	     * @param brand          the brand or manufacturer of the toy
	     * @param price          the retail price of the toy
	     * @param availableCount the quantity currently available in stock
	     * @param ageAppropriate the recommended minimum age rating for the toy
	     */
	    public Toy(String serialNumber, String name, String brand, double price, int availableCount, String ageAppropriate) {
	        this.serialNumber = serialNumber;
	        this.name = name;
	        this.brand = brand;
	        this.price = price;
	        this.availableCount = availableCount;
	        this.ageAppropriate = ageAppropriate;
	    }

	    /**
	     * Retrieves the serial number of the toy.
	     * 
	     * @return the 10 digit serial number
	     */
	    public String getSerialNumber() {
	        return serialNumber;
	    }

	    /**
	     * Updates the serial number of the toy.
	     * 
	     * @param serialNumber the new 10 digit serial number
	     */
	    public void setSerialNumber(String serialNumber) {
	        this.serialNumber = serialNumber;
	    }

	    /**
	     * Retrieves the name of the toy.
	     * 
	     * @return the toy name
	     */
	    public String getName() {
	        return name;
	    }

	    /**
	     * Updates the name of the toy.
	     * 
	     * @param name the new toy name
	     */
	    public void setName(String name) {
	        this.name = name;
	    }

	    /**
	     * Retrieves the brand of the toy.
	     * 
	     * @return the toy brand
	     */
	    public String getBrand() {
	        return brand;
	    }

	    /**
	     * Updates the brand of the toy.
	     * 
	     * @param brand the new toy brand
	     */
	    public void setBrand(String brand) {
	        this.brand = brand;
	    }

	    /**
	     * Retrieves the price of the toy.
	     * 
	     * @return the retail price
	     */
	    public double getPrice() {
	        return price;
	    }

	    /**
	     * Updates the price of the toy.
	     * 
	     * @param price the new retail price
	     */
	    public void setPrice(double price) {
	        this.price = price;
	    }

	    /**
	     * Retrieves the available stock count of the toy.
	     * 
	     * @return the number of items available
	     */
	    public int getAvailableCount() {
	        return availableCount;
	    }

	    /**
	     * Updates the available stock count of the toy.
	     * 
	     * @param availableCount the new stock quantity
	     */
	    public void setAvailableCount(int availableCount) {
	        this.availableCount = availableCount;
	    }

	    /**
	     * Retrieves the appropriate age rating for the toy.
	     * 
	     * @return the age rating string
	     */
	    public String getAgeAppropriate() {
	        return ageAppropriate;
	    }

	    /**
	     * Updates the appropriate age rating for the toy.
	     * 
	     * @param ageAppropriate the new age rating string
	     */
	    public void setAgeAppropriate(String ageAppropriate) {
	        this.ageAppropriate = ageAppropriate;
	    }

	    /**
	     * Decreases the available stock count by one when a toy is purchased,
	     * provided that at least one item is currently in stock.
	     */
	    public void decrementCount() {
	        if (this.availableCount > 0) {
	            this.availableCount--;
	        }
	    }

	    /**
	     * Formats the toy attributes into a semicolon delimited string matching the
	     * structure required for saving to the inventory data file.
	     * 
	     * @return a formatted string representation for file storage
	     */
	    public abstract String format();

	    /**
	     * Returns a human readable string displaying all shared toy attributes.
	     * 
	     * @return a formatted string describing the toy
	     */
	    @Override
	    public String toString() {
	        return String.format(
	                "Category: %s, Serial Number: %s, Name: %s, Brand: %s, Price: %.2f, Available Count: %d, Age Appropriate: %s",
	                this.getClass().getSimpleName(), serialNumber, name, brand, price, availableCount, ageAppropriate);
	    }
	

}
