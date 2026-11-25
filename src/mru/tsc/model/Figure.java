package mru.tsc.model;

/** A toy figure: Action, Doll, or Historic. */
public class Figure extends Toy {
	private String classification;

	public Figure(String serialNumber, String name, String brand, double price, int availableCount, int recommendedAge,
			String classification) {
		super(serialNumber, name, brand, price, availableCount, recommendedAge);
		this.classification = classification;
	}

	@Override
	public String getToyType() {
		return "Figure";
	}

	@Override
	public String toFileString() {
		return "";
		/* TODO */ }

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	@Override
	public String toString() {
		return "";
		/* TODO: vertical headers */ }
}
