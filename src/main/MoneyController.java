package main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MoneyController implements MoneyControllerInterface {
	private Inventory<Coin> coinInventory = new Inventory<Coin>();
	private double insertedMoney = 0.0;
	private Snack selectedSnack = null;
	private double calculatedChange = 0.0;
	private String returnedChange = "";
	private boolean isPaymentSuccessful = true;

	public MoneyController(Snack selectedSnack) {
		for (Coin i : Coin.values()) {
			coinInventory.addToInventory(i, 15);
		}

		this.selectedSnack = selectedSnack;
	}

	@Override
	public void validateMoney(String insertedMoney) {
		String[] enteredCoins = insertedMoney.split(" ");
		boolean isValidMoney = false;

		displayAccumulatedMoney();

		for (int i = 0; i < enteredCoins.length; i++) {
			isValidMoney = false;
			for (Coin item : Coin.values()) {
				if (item.getName().equals(enteredCoins[i])) {
					// accept money
					isValidMoney = true;
					coinInventory.increaseQuantity(item);
					this.insertedMoney = BigDecimal.valueOf(this.insertedMoney).add(BigDecimal.valueOf(item.getValue()))
							.doubleValue();
					displayAccumulatedMoney();
					break;
				}
			}

			if (!isValidMoney) {
				System.out.println(enteredCoins[i] + " is not recognized.");
			}
		}

		monitorMoney();
	}

	@Override
	public void displayAccumulatedMoney() {
		System.out.println("You inserted " + insertedMoney + "$");
	}

	@Override
	public void monitorMoney() {
		if (insertedMoney < selectedSnack.getPrice()) {
			isPaymentSuccessful = false;
			System.out.println("Sorry, the inserted money amount is not enough.");
			calculatedChange = insertedMoney;
			dispenseChange();
		} else {
			determineChange();
		}
	}

	@Override
	public void determineChange() {
		double calculatedChange = BigDecimal.valueOf(insertedMoney)
				.subtract(BigDecimal.valueOf(selectedSnack.getPrice())).doubleValue();
		this.calculatedChange = calculatedChange;

		if (calculatedChange > 0.0) {
			dispenseChange();
		}
	}

	@Override
	public void dispenseChange() {
		double remainedChange = calculatedChange;
		Coin[] coins = Coin.values();
		Arrays.sort(coins, Comparator.comparing(Coin::getValue).reversed());
		ArrayList<Coin> list = new ArrayList<Coin>();
		int numberOfCoins = 0;
		returnedChange = "";

		for (Coin item : coins) {
			numberOfCoins = (int) (remainedChange / item.getValue());
			if (numberOfCoins > 0) {
				int maxNumberOfCoins = Math.min(numberOfCoins, coinInventory.getQuantity(item));
				for (int i = 0; i < maxNumberOfCoins; i++) {
					coinInventory.decreaseQuantity(item);
					returnedChange += item.getName() + " ";
					remainedChange = BigDecimal.valueOf(remainedChange).subtract(BigDecimal.valueOf(item.getValue()))
							.doubleValue();
					list.add(item);
				}
			}
		}

		if (remainedChange == 0.0) {
			displayChange();
		} else {
			isPaymentSuccessful = false;
			System.out.println("Sorry we don't have sufficient change.");
			for (Coin item : list) {
				coinInventory.increaseQuantity(item);
			}
			calculatedChange = insertedMoney;
			dispenseChange();
		}
	}

	@Override
	public void displayChange() {
		System.out.println("Please take your " + (calculatedChange != insertedMoney ? "change" : "money") + " of "
				+ calculatedChange + "$");
		System.out.println("Which consists of " + returnedChange);
	}

	@Override
	public CreditCard isCardAvailable(String creditCardId) {
		CreditCard insertedCard = null;
		for (CreditCard card : CreditCard.values()) {
			if (creditCardId.equals(card.getCardId())) {
				insertedCard = card;
				break;
			}
		}

		return insertedCard;
	}

	@Override
	public void payWithCard(CreditCard insertedCard) {
		boolean cardHasEnoughBalance = checkCardBalance(insertedCard);
		if (cardHasEnoughBalance) {
			double oldBalance = insertedCard.getCardBalance();
			insertedCard.decrementBalance(selectedSnack.getPrice());
			System.out.println("Your card balance was " + oldBalance + "$, an amount of " + selectedSnack.getPrice()
					+ "$ is detucted from your card.");
			System.out.println("Your card balance is now " + insertedCard.getCardBalance() + "$.");
		} else {
			System.out.println("Sorry, the inserted card doesn't have enough balance.");
			isPaymentSuccessful = false;
		}

	}

	@Override
	public boolean checkCardBalance(CreditCard insertedCard) {
		return insertedCard.getCardBalance() < selectedSnack.getPrice() ? false : true;

	}

	@Override
	public boolean isPaymentSuccessful() {
		return isPaymentSuccessful;
	}

}
