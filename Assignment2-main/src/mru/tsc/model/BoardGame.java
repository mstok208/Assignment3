package mru.tsc.model;

import java.util.List;

/** A board game with a player range and one or more designers. */
public class BoardGame extends Toy {
	private int minPlayers;
	private int maxPlayers;
	private List<String> designers;

	public BoardGame(String serialNumber, String name, String brand, double price, int availableCount,
			int recommendedAge, int minPlayers, int maxPlayers, List<String> designers) {
		super(serialNumber, name, brand, price, availableCount, recommendedAge);
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;
		this.designers = designers;
	}

	@Override
	public String getToyType() {
		return "Board Game";
	}

	@Override
	public String toFileString() {
		return "";
		/* TODO */ }

	public int getMinPlayers() {
		return minPlayers;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public List<String> getDesigners() {
		return designers;
	}

	public void setDesigners(List<String> designers) {
		this.designers = designers;
	}

	@Override
	public String toString() {
		return "";
		/* TODO: vertical headers */ }
}
