import java.util.ArrayList;

public class Player {

  // Data Members
  private int money;
  Board.Counters playerPiece;
  Square position;
  boolean jail;
  int id;
  ArrayList<BuyableSquare> purchasedSquare = new ArrayList<>();
  int doublesRolled;
  int turnsInJail;
 
  // Constructors
  /**
   * Argumentless constructor.
   */
  public Player() {
    money = 200;
    playerPiece = null;
    position = null;
    jail = false;
    int doublesRolled = 0;
    turnsInJail = 0;
  }
  
  /**
   * Player Constructor with values.
   */
  public Player(Board.Counters playerPiece) {
    money = 200;
    this.playerPiece = playerPiece;
    position = null;
    jail = false;
    doublesRolled = 0;
    turnsInJail = 0;
  }

  // Instance methods
  public void setPosition(Square newPosition) {
    position = newPosition;
  }
  
  public Square getPosition() {
    return position;
  }
  
  public void setPlayerPiece(String piece) {
    this.playerPiece = Board.Counters.valueOf(piece.toUpperCase());
  }
  /**
   *Get Player Piece.
   */
  public String getPlayerPiece() { 
    String str = "";
    switch (this.playerPiece) {
      case DOG: str = "Dog"; break;
      case SHIP: str =  "Ship"; break;
      case CAR: str =  "Car"; break;
      case HAT: str =  "Hat"; break;
      case THIMBLE: str =  "Thimble"; break;
      case BOOT: str =  "Boot"; break;
      default: str =  ""; break;
    }
    return str;
  }

/*  public void setName(String newName) {
    this.name = newName;
  }

  public String getName() {
    return name;
  }*/

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
    money += 200;
  }

  public int getDoubles() {
    return doublesRolled; 
  }
  
  public void setDoubles(int amount) {
    doublesRolled = amount;
  }
  
  public ArrayList getProperties() {
    return purchasedSquare;
  }

  /**
   *Purchase square.
   */
  public boolean purchaseSquare(BuyableSquare square) {
    if (square.getOwner() == null) {
      square.setOwner(this);
      purchasedSquare.add(square);
      return true;
    } else {
      return false;
    }
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
   * Trade Property.
   */
  public void tradeProperty(Property propertyGiven, Property propertyReceived, Player otherPlayer) {
    
  }
  
  public void sellProperty(Property property, int moneyOffered, Player receiver) {
      
  }
  /**
   * Dice Rolling.
   */
 /* public void move(int dice1, int dice2) {
    if (dice1 == dice2) {
      doublesRolled++;
    } else {
      doublesRolled = 0;
    }

    if (doublesRolled == 3) {*/
      // add code below to set the position of the player to jail's position.
      // .
      // position = /*jail position*/;
/*
      jail = true;
    } else {
      position += dice1 + dice2;
    }
  }
*/

}// End of Player class
