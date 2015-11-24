public class CommunityChest extends Square {

  // Data members
  private int reward;

  // Constructor
  public CommunityChest(String name, int location) {
    super(name, location);
  }

  // Instance methods
  public int generateAmount() {
    return -1; /* amount generated from CommunityChest */
  }

}// End of CommunityChest class
