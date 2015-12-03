import java.util.HashMap;
import java.util.Map;


public class Game {


  Board board = new Board();

  Map<Board.Counters, Player> players = new HashMap<>();
    
  public void addPlayer(Player player) {
    players.put(player.counter, player);
  }

  public Player getPlayer(Board.Counters counter){
    return players.get(counter);
  }

  public void peformActionsAfterDiceRoll(Player player, int die1, int die2) {

    Square locationToMoveplayerTo = this.board.getDestinationSquare(player.currentSquare, die1 + die2);

      // Is there a teleport happening.
    if (locationToMoveplayerTo == this.board.getSquareByName("Go to Jail")) {
      locationToMoveplayerTo = this.board.getSquareByName("Visiting Jail");
      player.isInJail = true;
    }

    player.setLocation(locationToMoveplayerTo);
  }
}