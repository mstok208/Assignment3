package mru.tsc.model;

/**
 * Abstract parent class for every toy sold by the Toy Store Company. Stores
 * attributes shared by all toy types.
 */
public abstract class Toy {
	private final String serialNumber;
	private String name;
	private String brand;
	private double price;
	private int availableCount;
	private int recommendedAge;

	public Toy(String serialNumber, String name, String brand, double price, int availableCount, int recommendedAge) {
		// TODO: validate and assign the common attributes.
		this.serialNumber = serialNumber;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.availableCount = availableCount;
		this.recommendedAge = recommendedAge;
	}

	public abstract String getToyType();

	/**
	 * Returns this toy in the exact semicolon-delimited format used by toys.txt.
	 */
	public abstract String toFileString();

	public boolean purchase() {
		// TODO: reduce availableCount only when stock is available.
		return false;
	}

	public static boolean isValidSerialNumber(String serialNumber) {
		// TODO: exactly 10 digits, with a first digit matching the toy type.
		return false;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailableCount() {
		return availableCount;
	}

	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}

	public int getRecommendedAge() {
		return recommendedAge;
	}

	public void setRecommendedAge(int recommendedAge) {
		this.recommendedAge = recommendedAge;
	}
}
