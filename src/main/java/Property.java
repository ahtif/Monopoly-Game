
public class Property extends BuyableSquare {

	// Data members
	private String color;
	private int numOfHouses;

	// Instance methods
	public String getColor() {
		return color;
	}

	public void addHouse(int amountOfHouses) {
		numOfHouses += amountOfHouses;
	}

}// End of Property class
