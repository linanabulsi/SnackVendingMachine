package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.CreditCard;
import main.MoneyController;
import main.Snack;

public class MoneyControllerTest {
	MoneyController moneyController = new MoneyController(Snack.KITKAT);

	@Test
	public void testIsCardAvailable() {
		assertTrue(moneyController.isCardAvailable("12345")==CreditCard.CARD1);
		assertFalse(moneyController.isCardAvailable("53634")==CreditCard.CARD2);
	}

	@Test
	public void testCheckCardBalance() {
		assertTrue(moneyController.checkCardBalance(CreditCard.CARD1));
		assertFalse(moneyController.checkCardBalance(CreditCard.CARD4));
	}

	@Test
	public void testIsPaymentSuccessful() {
		moneyController.payWithCard(CreditCard.CARD1);
		assertTrue(moneyController.isPaymentSuccessful());
		moneyController.payWithCard(CreditCard.CARD4);
		assertFalse(moneyController.isPaymentSuccessful());		
	}

}
