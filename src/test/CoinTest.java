package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Coin;

public class CoinTest {
	Coin coin = Coin.TWENTY_CENTS;

	@Test
	public void testGetName() {
		assertTrue(coin.getName().equals("20c"));
	}

	@Test
	public void testGetValue() {
		assertTrue(coin.getValue() == 0.20);
	}

}
