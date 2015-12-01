public class CommunityChest extends Square {

  // Data members
  private int reward;

  // Constructor
  public CommunityChest(String name, int location) {
    super(name, location);
    // code for generating reward amount.
    this.reward = 100; // Temporally set at 100
  }

  // Instance methods
  public int generateAmount() {
    return reward; /* amount generated from CommunityChest */
  }

}// End of CommunityChest class
