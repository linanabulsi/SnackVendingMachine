package main;

public enum Coin {
	TEN_CENTS("10c", 0.1), TWENTY_CENTS("20c", 0.2), FIFTY_CENTS("50c", 0.5), ONE_DOLLAR("1$", 1.0),
	TWENTY_DOLLAR("20$", 20.0), FIFTY_DOLLAR("50$", 50.0);

	private String name;
	private double value;

	Coin(String name, double value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return this.name;
	}

	public double getValue() {
		return this.value;
	}
}
