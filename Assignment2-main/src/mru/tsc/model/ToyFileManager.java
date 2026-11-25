package mru.tsc.model;

import java.io.IOException;
import java.nio.file.Path;

/** Reads and writes the semicolon-delimited toys.txt data file. */
public class ToyFileManager {
	public void load(Path file, ToyInventory inventory) throws IOException {
		// TODO: parse each row and create the correct Toy subclass from the SN prefix.
	}

	public void save(Path file, ToyInventory inventory) throws IOException {
		// TODO: write each toy using toFileString().
	}

	public Toy parseLine(String line) {
		// TODO: split fields and instantiate Figure, Animal, Puzzle, or BoardGame.
		return null;
	}
}
