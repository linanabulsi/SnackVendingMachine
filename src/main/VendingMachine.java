package main;

public class VendingMachine implements VendingMachineInterface {
	private Inventory<Snack> snackInventory = new Inventory<Snack>();
	private Snack selectedSnack = null;
	private MoneyController moneyController;

	public VendingMachine() {
		for (Snack i : Snack.values()) {
			snackInventory.addToInventory(i, 5);
		}
		
		snackInventory.updateQuantity(Snack.KINDER, 0);
	}

	@Override
	public void displaySnacks() {
		System.out.println("WELCOME TO THE SNACK VENDING MACHINE");
		System.out.println("************************************");
		int i = 0;
		for (Snack item : Snack.values()) {
			System.out.print(item.getSlotNumber() + ". " + item.name() + "\t");
			i++;
			if(i==5) {
				i=0;
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("Please select your snack:");
	}

	@Override
	public void selectSnack(int snackNumber) {
		for (Snack item : Snack.values()) {
			if (item.getSlotNumber() == snackNumber) {
				selectedSnack = item;
				break;
			}
		}

		if (selectedSnack == null) {
			System.out.println("Sorry, this snack is not avai!");
			return;
		}

		// check if snack available
		boolean isSnackAvailable = snackInventory.checkIfAvailable(selectedSnack);

		if (!isSnackAvailable) {
			System.out.println("Sorry, we ran out of this snack! You can try another snack.");
			System.exit(0);
		}
	}

	@Override
	public void displaySnackAndPriceMessage() {
		System.out.println("The price of " + selectedSnack.name() + " is " + selectedSnack.getPrice() + "$.");
	}

	@Override
	public void getMoney(String insertedMoney) {
		moneyController = new MoneyController(selectedSnack);
		moneyController.validateMoney(insertedMoney);
	}

	@Override
	public void dispenseSnack() {
		if (moneyController.isPaymentSuccessful()) {
			snackInventory.decreaseQuantity(selectedSnack);
			System.out.println("Enjoy your " + selectedSnack.name() + "!");
		} else {
			System.out.println("You can try another snack.");

		}
	}

	@Override
	public void getCreditCard(String creditCardId) {
		CreditCard insertedCard;
		moneyController = new MoneyController(selectedSnack);
		insertedCard = moneyController.isCardAvailable(creditCardId);
		if (insertedCard != null) {
			moneyController.payWithCard(insertedCard);
		} else {
			System.out.println("Sorry, the inserted card is not available.");
			System.exit(0);
		}
	}

}
