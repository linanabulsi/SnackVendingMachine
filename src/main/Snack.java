package main;

public enum Snack {
	KINDER(1, 20.20), KITKAT(2, 15.50), GALAXY(3, 10.0), FLAKE(4, 7.30), MARS(5, 24.60), TWIRL(6, 3.0),
	SNICKERS(7, 7.40), MILKA(8, 25.20), CADBURY(9, 17.60), MMS(10, 5.60), OREO(11, 8.0), TWIX(12, 11.50),
	FERRERO(13, 29.20), HERSHEYS(14, 2.30), TOBLERONE(15, 4.60), BOUNTY(16, 14.0), PRIGNLES(17, 15.50),
	CHEETOS(18, 44.20), DORITOS(19, 5.30), BUGLES(20, 23.8), LAYS(21, 33.3), LION(22, 0.50), TAKIS(23, 1.0),
	CHESTERS(24, 9.30), FRITOS(25, 0.60);

	private int slotNumber;
	private double price;

	Snack(int slotNumber, double price) {
		this.slotNumber = slotNumber;
		this.price = price;
	}

	public int getSlotNumber() {
		return this.slotNumber;
	}

	public double getPrice() {
		return this.price;
	}

}
