package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Snack;

public class SnackTest {
	Snack snack = Snack.KITKAT;

	@Test
	public void testGetSlotNumber() {
		assertTrue(snack.getSlotNumber() == 2);
	}

	@Test
	public void testGetPrice() {
		assertTrue(snack.getPrice() == 15.5);
	}

}
