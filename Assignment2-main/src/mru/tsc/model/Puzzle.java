package mru.tsc.model;

/** A puzzle toy. */
public class Puzzle extends Toy {
	private String puzzleType;

	public Puzzle(String serialNumber, String name, String brand, double price, int availableCount, int recommendedAge,
			String puzzleType) {
		super(serialNumber, name, brand, price, availableCount, recommendedAge);
		this.puzzleType = puzzleType;
	}

	@Override
	public String getToyType() {
		return "Puzzle";
	}

	@Override
	public String toFileString() {
		return "";
		/* TODO */ }

	public String getPuzzleType() {
		return puzzleType;
	}

	public void setPuzzleType(String puzzleType) {
		this.puzzleType = puzzleType;
	}

	@Override
	public String toString() {
		return "";
		/* TODO: vertical headers */ }
}
