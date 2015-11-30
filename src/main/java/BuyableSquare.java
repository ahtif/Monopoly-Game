
public class BuyableSquare extends Square{

    // Data members
  protected int cost; 
  protected int rent; 
  protected int multiplier;
  protected int mortgagePrice;

    
  /**  
   * Constructor for buyable square.
   * @param name the name of the square
   * @param location the location of the square
   * @param cost the cost of the square
   * @param rent the rent amount
   * @param multiplier the multiplier
   * @param mortgagePrice the mortgage 
   */
  public BuyableSquare(String name, int location, int cost, 
      int rent, int multiplier, int mortgagePrice) {
    super(name, location);
    this.cost = cost;
    this.rent = rent;
    this.multiplier = multiplier;
    this.mortgagePrice = mortgagePrice;
  }

    // Instance methods
  public void setOwner(String owner) {
    // Code to set owner's name.
  }

  public String getOwner() {
    return "owner";  /* Insert real name*/
  }

  public void setPrice(int price) {
    cost = price;
  }

  public int getPrice() {
    return cost;
  }

  public int getMortgage() {
    return mortgagePrice;
  }

}// End of BuyableSquare class
