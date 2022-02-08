package main;
import java.util.Scanner;

public class Keypad {
	Scanner scanner = new Scanner(System.in);

	int readSnackNumber() {
		int selectedSnackSlot = 0;
		while (true) {
			String selectedSnack = scanner.nextLine();
			try {
				selectedSnackSlot = Integer.parseInt(selectedSnack);
				if (selectedSnackSlot < 1 || selectedSnackSlot > 25) {
					System.out.println("Please enter a valid snack number:");
					continue;
				}
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid snack number:");
				continue;
			}
			return selectedSnackSlot;
		}
	}

	int readPaymentMethod() {
		int paymentMethod = 0;
		while (true) {
			System.out.println("Please select your payment method:");
			System.out.println("1. Cash             2. Credit card");
			String method = scanner.nextLine();
			try {
				paymentMethod = Integer.parseInt(method);
				if (paymentMethod != 1 && paymentMethod != 2) {
					continue;
				}
			} catch (NumberFormatException e) {
				continue;
			}
			return paymentMethod;
		}
	}

	String readInsertedMoney() {
		System.out.println("Please insert money:");
		String insertedMoney = scanner.nextLine();
		return insertedMoney;
	}

	String readCreditCardId() {
		System.out.println("Please insert your card Id:");
		String cardId = scanner.nextLine();
		return cardId;
	}

}
