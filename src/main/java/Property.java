
public class Property extends BuyableSquare {

  // Data members
  private String color;
  private int numOfHouses;

  /**
   * Property Basics.
   */
  public Property(String name, int location, int cost, int rent, int multiplier,
      int mortgagePrice, String color, int numOfHouses) {
    super(name, location, cost, rent, multiplier, mortgagePrice);
    this.color = color;
    this.numOfHouses = numOfHouses;
  }

  // Instance methods
  public String getColor() {
    return color;
  }

  public void addHouse(int amountOfHouses) {
    numOfHouses += amountOfHouses;
  }

}// End of Property class
