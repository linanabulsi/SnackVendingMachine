package main;

public interface VendingMachineInterface {
	void displaySnacks();

	void selectSnack(int snackNumber);

	void displaySnackAndPriceMessage();

	void getCreditCard(String creditCardId);

	void getMoney(String insertedMoney);

	void dispenseSnack();
}
