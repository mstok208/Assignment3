package mru.tsc.model;

public class Animal extends Toy {
	

	/**
	 * Represents an animal toy in the Toy Store Company inventory.
	 * Extends the abstract Toy class by adding material and size attributes.
	 * 
	 * @author Ali, Manmeet
	 */
	
	    private String material;
	    private String size;

	    /**
	     * Constructs a new Animal object with all shared and animal specific attributes.
	     * 
	     * @param serialNumber   the unique 10 digit serial number starting with 2 or 3
	     * @param name           the name of the animal toy
	     * @param brand          the brand or manufacturer of the animal toy
	     * @param price          the retail price of the animal toy
	     * @param availableCount the quantity currently available in stock
	     * @param ageAppropriate the recommended minimum age rating for the animal toy
	     * @param material       the primary material used to make the animal toy
	     * @param size           the size category of the animal toy such as Small, Medium, or Large
	     */
	    public Animal(String serialNumber, String name, String brand, double price, int availableCount,
	                  String ageAppropriate, String material, String size) {
	        super(serialNumber, name, brand, price, availableCount, ageAppropriate);
	        this.material = material;
	        this.size = size;
	    }

	    /**
	     * Retrieves the material of the animal toy.
	     * 
	     * @return the material string
	     */
	    public String getMaterial() {
	        return material;
	    }

	    /**
	     * Updates the material of the animal toy.
	     * 
	     * @param material the new material string
	     */
	    public void setMaterial(String material) {
	        this.material = material;
	    }

	    /**
	     * Retrieves the size category of the animal toy.
	     * 
	     * @return the size category
	     */
	    public String getSize() {
	        return size;
	    }

	    /**
	     * Updates the size category of the animal toy.
	     * 
	     * @param size the new size category
	     */
	    public void setSize(String size) {
	        this.size = size;
	    }

	    /**
	     * Formats the animal attributes into a semicolon delimited string matching the
	     * structure required for saving to the inventory data file.
	     * 
	     * @return a formatted string representation for file storage
	     */
	    @Override
	    public String format() {
	        return String.format("%s;%s;%s;%.2f;%d;%s;%s;%s",
	                getSerialNumber(), getName(), getBrand(), getPrice(), getAvailableCount(), getAgeAppropriate(), material, size);
	    }

	    /**
	     * Returns a human readable string displaying all animal attributes.
	     * 
	     * @return a formatted string describing the animal toy
	     */
	    @Override
	    public String toString() {
	        return super.toString() + ", Material: " + material + ", Size: " + size;
	    }
	
	

}
