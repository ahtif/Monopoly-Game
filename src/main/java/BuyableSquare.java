
public class BuyableSquare extends Square{

  // Data members
  protected int cost; 
  protected int rent; 
  protected int multiplier;
  protected int mortgagePrice;
  protected String owner;
  protected Square propertyLocation;
    
  /**  
   * Constructor for buyable square.
   * @param name the name of the square
   * @param location the location of the square
   * @param cost the cost of the square
   * @param rent the rent amount
   * @param multiplier the multiplier
   * @param mortgagePrice the mortgage 
   */

  public BuyableSquare(String name, int location, int cost, int rent,
      int multiplier, int mortgagePrice) {
    super(name, location);
    this.cost = cost;
    this.rent = rent;
    this.multiplier = multiplier;
    this.mortgagePrice = mortgagePrice;
    owner = null;
  }

  // Instance methods
  
  //needs to check if player has enough money 
  public void setOwner(Player player, Square square) {
    owner = player.getPlayerPiece();
    propertyLocation = square;
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

  public int getRent() {
    return rent;
  }
  
  public int getMortgage() {
    return mortgagePrice;
  }
  
  /**
   * addMoneyMortgage Square.
   */
  public void mortgageSquare(Player player) {
    int mortgagePrice = getMortgage();
    player.addMoney(mortgagePrice);
    owner = "";
  }

}// End of BuyableSquare class
