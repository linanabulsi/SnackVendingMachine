package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.CreditCard;

public class CreditCardTest {
	CreditCard card = CreditCard.CARD1;

	@Test
	public void testGetCardId() {
		assertTrue(card.getCardId() == "12345");
	}

	@Test
	public void testGetCardBalance() {
		assertTrue(card.getCardBalance() == 40.1);
	}

	@Test
	public void testDecrementBalance() {
		assertTrue(card.getCardBalance() == 40.1);
		card.decrementBalance(20.4);
		assertTrue(card.getCardBalance() == 19.7);
		card.decrementBalance(5.9);
		assertTrue(card.getCardBalance() == 13.8);
	}

}
