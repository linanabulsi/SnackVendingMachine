package main;

import java.math.BigDecimal;

public enum CreditCard {
	CARD1("12345", 40.1), CARD2("22222", 25.2), CARD3("12321", 10.5), CARD4("67890", 4.0);

	private String cardId;
	private double balance;

	CreditCard(String cardId, double balance) {
		this.cardId = cardId;
		this.balance = balance;
	}

	public String getCardId() {
		return this.cardId;
	}

	public double getCardBalance() {
		return this.balance;
	}

	public void decrementBalance(double value) {
		this.balance = BigDecimal.valueOf(this.balance).subtract(BigDecimal.valueOf(value)).doubleValue();
	}
}
