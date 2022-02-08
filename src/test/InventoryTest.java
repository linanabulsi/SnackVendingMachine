package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Inventory;
import main.Snack;

public class InventoryTest {
	private Inventory<Snack> snackInventory = new Inventory<Snack>();

	@Test
	public void testAddToInventory() {
		snackInventory.addToInventory(Snack.KINDER, 3);
		assertTrue(snackInventory.getQuantity(Snack.KINDER)==3);
	}

	@Test
	public void testUpdateQuantity() {
		snackInventory.updateQuantity(Snack.KINDER, 5);
		assertTrue(snackInventory.getQuantity(Snack.KINDER)==5);
	}

	@Test
	public void testGetQuantity() {
		snackInventory.addToInventory(Snack.KINDER, 3);
		assertTrue(snackInventory.getQuantity(Snack.KINDER)==3);
	}

	@Test
	public void testDecreaseQuantity() {
		snackInventory.addToInventory(Snack.KINDER, 3);
		snackInventory.decreaseQuantity(Snack.KINDER);
		assertTrue(snackInventory.getQuantity(Snack.KINDER)==2);
	}

	@Test
	public void testIncreaseQuantity() {
		snackInventory.addToInventory(Snack.KINDER, 3);
		snackInventory.increaseQuantity(Snack.KINDER);
		assertTrue(snackInventory.getQuantity(Snack.KINDER)==4);
	}

	@Test
	public void testCheckIfAvailable() {
		snackInventory.addToInventory(Snack.KINDER, 3);
		assertTrue(snackInventory.checkIfAvailable(Snack.KINDER));
		snackInventory.addToInventory(Snack.GALAXY, 0);
		assertFalse(snackInventory.checkIfAvailable(Snack.GALAXY));
	}

}
