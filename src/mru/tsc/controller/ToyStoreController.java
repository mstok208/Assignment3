package mru.tsc.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import mru.tsc.model.*;

/** Coordinates operations between the view, inventory, and file manager. */
public class ToyStoreController {
	private final ToyInventory inventory;
	private final ToyFileManager fileManager;
	private final Path dataFile;

	public ToyStoreController(Path dataFile) {
		this.inventory = new ToyInventory();
		this.fileManager = new ToyFileManager();
		this.dataFile = dataFile;
	}

	public void loadInventory() throws IOException {
		/* TODO */ }

	public List<Toy> searchBySerialNumber(String serialNumber) {
		/* TODO */ return null;
	}

	public List<Toy> searchByName(String name) {
		/* TODO */ return null;
	}

	public List<Toy> searchByType(String type) {
		/* TODO */ return null;
	}

	public boolean purchase(String serialNumber) {
		/* TODO */ return false;
	}

	public boolean addToy(Toy toy) {
		/* TODO */ return false;
	}

	public boolean removeToy(String serialNumber) {
		/* TODO */ return false;
	}

	public void saveInventory() throws IOException {
		/* TODO */ }

	public List<Toy> getAllToys() {
		return inventory.getAllToys();
	}
}
