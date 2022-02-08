package main;

import java.util.HashMap;
import java.util.Map;

public class Inventory<T> {
	private Map<T, Integer> inventory = new HashMap<T, Integer>();

	public void addToInventory(T obj, int quantity) {
		inventory.put(obj, quantity);
	}

	public void updateQuantity(T obj, int quantity) {
		inventory.put(obj, quantity);
	}

	public int getQuantity(T obj) {
		return inventory.get(obj);
	}

	public void decreaseQuantity(T obj) {
		if(getQuantity(obj) > 0) {
		int oldQuantity = inventory.get(obj);
		inventory.put(obj, oldQuantity - 1);
		}
	}

	public void increaseQuantity(T obj) {
		int oldQuantity = inventory.get(obj);
		inventory.put(obj, oldQuantity + 1);
	}

	public boolean checkIfAvailable(T obj) {
		int quantity = getQuantity(obj);
		return quantity > 0 ? true : false;
	}

	public void printInventory() {
		System.out.println(inventory);
	}

}
