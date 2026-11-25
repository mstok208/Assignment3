package mru.tsc.model;

import java.util.ArrayList;
import java.util.List;

/** Holds all toy subclasses in one polymorphic ArrayList. */
public class ToyInventory {
	private final ArrayList<Toy> toys = new ArrayList<>();

	public List<Toy> getAllToys() {
		return toys;
	}

	public Toy findBySerialNumber(String serialNumber) {
		return null;
		/* TODO */ }

	public List<Toy> searchByName(String searchText) {
		return new ArrayList<>();
		/* TODO */ }

	public List<Toy> searchByType(String type) {
		return new ArrayList<>();
		/* TODO */ }

	public boolean addToy(Toy toy) {
		return false;
		/* TODO: reject duplicate SN */ }

	public boolean removeBySerialNumber(String serialNumber) {
		return false;
		/* TODO */ }

	public boolean purchaseBySerialNumber(String serialNumber) {
		return false;
		/* TODO */ }
}
