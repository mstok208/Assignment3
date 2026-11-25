package mru.tsc.model;

/** A toy animal with a material and size. */
public class Animal extends Toy {
	private String material;
	private String size;

	public Animal(String serialNumber, String name, String brand, double price, int availableCount, int recommendedAge,
			String material, String size) {
		super(serialNumber, name, brand, price, availableCount, recommendedAge);
		this.material = material;
		this.size = size;
	}

	@Override
	public String getToyType() {
		return "Animal";
	}

	@Override
	public String toFileString() {
		return "";
		/* TODO */ }

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "";
		/* TODO: vertical headers */ }
}
