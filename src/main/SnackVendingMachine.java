package main;

public class SnackVendingMachine {
	public static void main(String[] args) {
		VendingMachineInterface vendingMachine = new VendingMachine();

		Keypad keypad = new Keypad();

		vendingMachine.displaySnacks();

		int selectedSnackSlot = keypad.readSnackNumber();
		vendingMachine.selectSnack(selectedSnackSlot);

		vendingMachine.displaySnackAndPriceMessage();

		int paymentMethod = keypad.readPaymentMethod();

		if (paymentMethod == 1) {
			String insertedMoney = keypad.readInsertedMoney();
			vendingMachine.getMoney(insertedMoney);
		} else {
			String creditCardId = keypad.readCreditCardId();
			vendingMachine.getCreditCard(creditCardId);
		}

		vendingMachine.dispenseSnack();
	}

}
