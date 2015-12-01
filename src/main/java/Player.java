//import BuyableSquare.java;
public class Player {

  // Data Members
  private int money;
  private String name;
  private String playerPiece;
  private int position;
  private boolean jail;
  private int doublesRolled;
    
  // Constructors
  /**
   * Player Constructor.
   */
  public Player() {
    money = 200;
    name = "";
    playerPiece = "";
    position = 0;
    jail = false;
    int doublesRolled = 0;
  }

  /**
   * Player values.
   */
  public Player(String name, String playerPiece) {
    money = 200;
    this.name = name;
    this.playerPiece = playerPiece;
    position = 0;
    jail = false;
    int doublesRolled = 0;
  }

  // Instance methods
  public void setPosition(int newPosition) {
    position = newPosition;
  }
  
  public int getPosition() {
    return position;
  }

  public void setName(String newName) {
    this.name = newName;
  }

  public String getName() {
    return name;
  }

  public int getMoney() {
    return money;
  }
  
  public void setMoney(int amount) {
    money = amount;
  }
  
  public void addMoney(int amount) {
    this.money += amount;
  }

  public void subtractMoney(int amount) {
    this.money -= amount;
  }

  public void passGo() {
    // Assume passGo will give 200.
    money += 200;
  }

  public int getDoubles() {
    return doublesRolled; 
  }
  
  public void setDoubles(int amount) {
    doublesRolled = amount;
  }
  
  public void /*switch with void later: BuyableSquares[]*/ getProperties() {
    //return; //temporary to allow for program to compile
  }

  public boolean purchaseSquare(/*BuyableSquares square*/) {
    return false; //temporary
  }

  /**
   * Rent paying.
   */
  public void payRent(int rentAmount, Player receiver) {
    this.subtractMoney(rentAmount);
    receiver.addMoney(rentAmount);
    // N.B. Haven't deal with if the player goes bankrupt.
  }

  /**
   * Jail Time Remaining.
   */
  public void remainingJailTime() {
    // N.B. Not quite clear about what to do in this method.
  }

  /**
   * Jail check.
   */
  public boolean jailCheck() {
    return jail;
  }
  
  /**
   * Set Jail.
   */
  public void setJail(boolean toggle) {
    jail = toggle;
  }
  /**
   * Dice Rolling.
   */
  public void move(int dice1, int dice2) {
    if (dice1 == dice2) {
      doublesRolled++;
    } else {
      doublesRolled = 0;
    }

    if (doublesRolled == 3) {
      // add code below to set the position of the player to jail's position.
      // .
      // position = /*jail position*/;

      jail = true;
    } else {
      position += dice1 + dice2;
    }
  }


}// End of Player class
