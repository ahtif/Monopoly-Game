public class Jail extends Square {
  
  // Data members
  private int numOfPlayerInJail;
  // Need a map to remember number of rounds left for each player in jail.
  
  /**
   * Jail Constructor
   */
  public Jail() {
    this.numOfPlayerInJail = 0;
  }
  
  public void goJail() {
    this.numOfPlayerInJail++;
  }
  
  public boolean did_Pay() {
    return true;
  }

}// End of Jail class
