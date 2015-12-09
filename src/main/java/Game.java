import java.util.HashMap;
import java.util.Map;

public class Game {


  Board board = new Board();

  Map<Board.Counters, Player> players = new HashMap<>();
    
  public void addPlayer(Player player) {
    players.put(player.playerPiece, player);
  }

  public Player getPlayer(Board.Counters counter) {
    return players.get(counter);
  }

  /**
   * Checks if the player landed on the go to jail square, and sends them to jail if true.
   * @param player the player to be moved
   * @param die1 the value of the first dice
   * @param die2 the value of the second dice
   */
  public void peformActionsAfterDiceRoll(Player player, int die1, int die2) {

    Square locationToMoveplayerTo = 
        this.board.getDestinationSquare(player.getPosition(), die1 + die2);

      // Is there a teleport happening.
    if (locationToMoveplayerTo == this.board.getSquareByName("Go To Jail")) {
      locationToMoveplayerTo = this.board.getSquareByName("Jail");
      player.setJail(true);
    }
    
    player.setPosition(locationToMoveplayerTo);
  }
}