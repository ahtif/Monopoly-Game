public class RailRoad extends BuyableSquare {

	// Data members
	private String color;

	// Constructors
	public RailRoad(String name, int location, int cost, int rent, int multiplier, int mortgagePrice, String color) {
		super(name, location, cost, rent, multiplier, mortgagePrice);
		this.color = color;
	}

	// Instance methods
	public void setMultiplier(int multiplier) {
		super.muiltiplier = multiplier;
	}

	public String getColor() {
		return color;
	}

}// End of RailRoad class
