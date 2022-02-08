package main;

public interface MoneyControllerInterface {
	void validateMoney(String insertedMoney);

	void displayAccumulatedMoney();

	void monitorMoney();

	void determineChange();

	void dispenseChange();

	void displayChange();

	CreditCard isCardAvailable(String creditCardId);

	void payWithCard(CreditCard insertedCard);

	boolean checkCardBalance(CreditCard insertedCard);

	boolean isPaymentSuccessful();
}
