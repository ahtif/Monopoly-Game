import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import cucumber.api.PendingException;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Stepdefs {
 // remove for testing

  Game testGame;

  private MonopolyDao persistence = new MonopolyDao();


  /** 
   * Always executed before any step definition.
   */ 
  @Before 
  public void beforeScenario() {
    testGame = new Game();
  //  testGame.players.put(1, new Player(1, testBoard.square.get(0)));
   // testGame.players.put(2, new Player(2, testBoard.square.get(0)));
//   persistence.persistGame(testGame);
  }
  /** Always executed after a step definition.
   */
  @After
  public void afterScenario() {
 /*   Board testGame = persistence.findGameByName("test-game-1");
    persistence.removeGame(testBoard);
    persistence.removeGame(persistence.findGameByName("test-board-2"));
    persistence.removeGame(persistence.findGameByName("test-board-3"));*/
  }

  // PLayer Movement
  /**
   * Set the player to start on the given square name.
   * @param playerName The player's piece.
   * @param squareName The square to start on.
   */
  @Given("^Player (.*) started on the (.*) square$")
  public void player_started_on(String playerName, String squareName) throws Throwable {
    Player player  = new Player(Board.Counters.valueOf(playerName.toUpperCase()));
    testGame.addPlayer(player);
    player.setPosition(testGame.board.getSquareByName(squareName));
  }
  
  @When("^Player (.*) rolls a (\\d+) and a (\\d+)$")
  public void player_rolls(String playerName, int dice1, int dice2) throws Throwable {
    Player player = testGame.getPlayer(Board.Counters.valueOf(playerName.toUpperCase()));
    testGame.peformActionsAfterDiceRoll(player, dice1, dice2);
  }
  
  /**
   * Make sure the player is on a given square.
   * @param playerName The player name
   * @param squareName The square name
   */
  @Then("^Player (.*) should be on (.*)$")
  public void player_should_be_on(String playerName, String squareName) throws Throwable {
    Player player = testGame.getPlayer(Board.Counters.valueOf(playerName.toUpperCase()));  
    Square square = testGame.board.getSquareByName(squareName);
    assertEquals(player.getPosition(), square);
  }  
  
  @Then("^Player (.*) is in Jail$")
  public void player_is_in_Jail(String playerName) throws Throwable {
    Player player = testGame.getPlayer(Board.Counters.valueOf(playerName.toUpperCase()));
    assertTrue(player.jail);
  }
  
  @Then("^Player (.*) is not in Jail$")
  public void player_is_not_in_Jail(String playerName) throws Throwable {
    Player player = testGame.getPlayer(Board.Counters.valueOf(playerName.toUpperCase()));
    assertFalse(player.jail);
  }
  
  /**
   * Checks that the player gains money for passing GO.
   * @param playerName The player's name.
   * @param amt Amount to gain.
   */
  @Then("^Player (.*) should gain (\\d+) for passing Go$")
  public void player_pass_go(String playerName, int amt) throws Throwable {
    Player player = testGame.getPlayer(Board.Counters.valueOf(playerName.toUpperCase()));  
    int oldMoney = player.getMoney();
    player.passGo();
    assertEquals(oldMoney + amt, player.getMoney()); 
  }
  
  /**
   * Checks the player gains the correct amount for landing on a chance.
   * @param playerName The player's name.
   * @param amt Amount to gain.
   * @param squareName The chance square to land on.
   */
  @Then("^Player (.*) should gain (\\d+) for landing on (.*)$")
  public void gain_on_chance(String playerName, int amt, String squareName) throws Throwable {
    Player player = testGame.getPlayer(Board.Counters.valueOf(playerName.toUpperCase()));  
    int oldMoney = player.getMoney();
    Square square = testGame.board.getSquareByName(squareName);
    if (square.getName().startsWith("Chance")) {
      Chance chance = (Chance) testGame.board.getSquareByName(squareName);
      player.addMoney(chance.getAmount());
    } else {
      CommunityChest chest = (CommunityChest) square;
      player.addMoney(chest.getReward());
    }
    assertEquals(oldMoney + amt, player.getMoney()); 
  } 
  
  /**
   * Checks the player gains the correct amount for landing on a chance.
   * @param playerName The player's name.
   * @param amt Amount to gain.
   * @param chanceSquare The chance square to land on.
   */
  @Then("^Player (.*) should lose (\\d+) for landing on (.*)$")
  public void landing_on_chance(String playerName, int amt, String chanceSquare) throws Throwable {
    Player player = testGame.getPlayer(Board.Counters.valueOf(playerName.toUpperCase()));  
    int oldMoney = player.getMoney();
    Chance chance = (Chance) testGame.board.getSquareByName(chanceSquare);
    player.addMoney(chance.getAmount());
    assertEquals(oldMoney - amt, player.getMoney()); 
  }   
  
  @Given("^Player (.*) is Jailed$")
  public void player_is_Jailed(String playerName) throws Throwable {
    Player player = testGame.getPlayer(Board.Counters.valueOf(playerName.toUpperCase()));
    player.setJail(true);
  }

  @Given("^Player (.*) has (\\d+)$")
  public void player_has(String playerName,int amt) throws Throwable {
    Player player = testGame.getPlayer(Board.Counters.valueOf(playerName.toUpperCase()));
    player.setMoney(amt);
  }
  
  /**
   * Set a player free from jail and subtracts £50.
   * @param playerName the name of the player
   */
  @When("^Player (.*) wants to leave Jail early$")
  public void player_Ship_wants_to_leave_jail_early(String playerName) throws Throwable {
    Player player = testGame.getPlayer(Board.Counters.valueOf(playerName.toUpperCase()));
    player.leaveJail();
  }

  @Then("^Player (.*) should have (\\d+)$")
  public void player_Ship_should_have(String playerName,int amt) throws Throwable {
    Player player = testGame.getPlayer(Board.Counters.valueOf(playerName.toUpperCase()));
    assertEquals(player.getMoney(),amt);
  }

  
/* 
  
  // Tests for persistence 
  @Given("^we are having a game of monopoly$")
  public void we_are_having_a_game_of_monopoly() throws Throwable {
    this.testGame = new Game;
}

  @Given("^a player join the game as (.+)$")
  public void a_player_join_the_game_as(String playerName) throws Throwable {
    Player player  = new Player(Board.Counters.valueOf(playerName.toUpperCase()));
   
}

// saves initial game 
  @When("^we save the game as (.+)$")
  public void we_save_the_game_as(String saveGameName) throws Throwable {
    testGame.Board.name = saveGameName;
    persistence.persistGame(board);
}

  @Then("^the board has an id$")
  public void the_board_has_an_id() throws Throwable {
    assertTrue(board.id != 0);
}

// load a saved game
  @Given("^we load the saved game (.+)$")
  public void we_load_the_saved_game(String gameName) throws Throwable {
    testGame.Board.name = persistence.findGameByName(gameNameame);
}

// Saves a game, loads another game, the loads the first game 
  @Given("^Player (.+) rolls a (\\d+) and a (\\d+)$")
  public void player_rolls(String playerName, int dice1, int dice2) throws Throwable {
    Player player = testGame.getPlayer(Board.Counters.valueOf(playerName.toUpperCase()));
    testGame.peformActionsAfterDiceRoll(player, dice1, dice2);
}

  @Given("^we save the game as (.+)$")
  public void we_save_the_game_as(String saveGameName) throws Throwable {
    testGame.Board.name = saveGameName;
	persistence.persistGame(testGame);
}

  @When("^we load the saved game (.+)$")
  public void we_load_the_saved_gameString gameName) throws Throwable {
    testGame.Board = persistence.findGameByName(gameNameame);
}

  
  
  //////////////////////////////////////////////////////////////////////////////////
  @When("^a (\\d+) and a (\\d+) are rolled and are the same number$")
  public void double_is_rolled(int dice1, int dice2) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    player.move(dice1, dice2);
  }

  @Then("^Player (\\d+) should be on (\\d+)$")
  public void player_should_be_on_oxford_Street(int playerNumber, 
      int squareNumber) throws Throwable {
    assertEquals(player.getPosition(), squareNumber);
  }
//////////////////////////////////////////////////////////////////////////////////
  //check doubles counter works
  @Given("^Player (\\d+) started on the Go square$")
  public void player_starts_on_the_Go_square(int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    player.setPosition(0);
  }

  @When("^a (\\d+) and a (\\d+) are rolled and are the same number$")
  public void double_roll(int dice1, int dice2) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    player.move(dice1, dice2);
  }
  
  @Then("^it should be Player (\\d+) turn again$")
  public void it_should_be_Player_turn_again(int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    int doubles = player.getDoubles();
    assertEquals(doubles, 1); // check that doubles has increased from 0 to 1
  }

//////////////////////////////////////////////////////////////////////////////////
 // check visit jail
  @Given("^Player (\\d+) has not been sent to Jail$")
  public void player_has_not_been_sent_to_Jail(int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);
  }

  @When("^Player (\\d+) land on the Jail Square$")
  public void player_land_on_the_Jail_Square(int arg1) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    player.setPosition(10);
  }

  @Then("^Player (\\d+) may leave on their next turn$")
  public void player_may_leave_on_their_next_turn(int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    assertEquals(player.jailCheck(), false);
  }
  

////////////////////////////////////////////////////////////////////////////////// 
  // pass go check
  
  @Given("^Player (\\d+) starts their turn before the Go square$")
  public void player_starts_their_turn_before_the_Go_square(int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    player.setPosition(35);

  }

  @When("^Player (\\d+) lands on the Go square$")
  public void player_lands_on_the_Go_square(int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    player.move(3, 2);
  }

//////////////////////////////////////////////////////////////////////////////////
   //addMoneyHELP//
 
  
  @Given("^Player (\\d+) lands on the Go To Jail square$")
  public void player_lands_on_the_Go_To_Jail_square(int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    player.setPosition(30);
  }
 
  @Then("^Player (\\d+) should move directly to the Jail Square$")
  public void player_should_move_directly_to_the_Jail_Square(int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    Board board = new Board();
    //board.GoToJail.sentToJail(player);
  }
  

  @Then("^Player (\\d+) should not collect (\\d+)$")
  public void player_should_not_collect(int playerNumber, int goMoney, 
      int oldMoney) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    int money = player.getMoney();
    assertNotEquals(money, old_money + goMoney); // make sure no collection

  }

//////////////////////////////////////////////////////////////////////////////////
  // chance check
  @Given("^PLayer (\\d+) is on Vine Street$")
  public void player_is_on_vine_street(int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    player.setPosition(19);
  }

  @When("^Player (\\d+) rolls a (\\d+) and a (\\d+)$")
  public void player_rolls_a(int playerNumber, int dice1, int dice2) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    player.move(dice1, dice2);
  }

  //what to do here?
  @When("^land on a chance square$")
  public void land_on_a_chance_square() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }
  
 
  @Then("^Player (\\d+) gains$")
  public void player_gains(int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    Chance chance = new Chance(player.getName(), 22);
    int oldMoney = player.getMoney();
    int chanceAmount = chance.generateAmount();
    assertNotEquals(player.getMoney(), old_money);
  }

//////////////////////////////////////////////////////////////////////////////////
  // Community chest check
  @Given("^Player (\\d+) is on Pentonville Road$")
  public void player_is_on_Pentonville_Road(int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    player.setPosition(9);
  }

  @When("^Player (\\d+) rolls a (\\d+) and a (\\d+)$")
  public void player_rolls_an(int playerNumber, int dice1, int dice2) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    player.move(dice1, dice2);
  }

  // What to put here?
  @When("^lands on a Community Chest$")
  public void lands_on_a_Community_Chest() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }
  
 
  @Then("^Player (\\d+) should gain £(\\d+)$")
  public void player_should_gain(int arg1, int arg2) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    CommunityChest chest = new CommunityChest(player.getName(), 22);
    int oldMoney = player.getMoney();
    int chanceAmount = chest.generateAmount();
    assertNotEquals(player.getMoney(), old_money);
  }

//////////////////////////////////////////////////////////////////////////////////
 
  //TODO need remaining jail time to be figured out 
  
  @Given("^Player (\\d+) is in jail and they have only rolled once$")
  public void player_is_in_jail_and_they_have_only_rolled_once(int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    
  }

  @When("^Player (\\d+) rolls$")
  public void player_rolls(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @When("^the dice do not show the same number$")
  public void the_dice_do_not_show_the_same_number() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^Player (\\d+) should remain in Jail$")
  public void player_should_remain_in_Jail(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

//////////////////////////////////////////////////////////////////////////////////
  // doubles roll in jail
  @Given("^Player (\\d+) is in Jail$")
  public void player_is_in_Jail(int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    player.setJail(true);
  }
  
  @When("^Player (\\d+) rolls doubles$")
  public void player_rolls_doubles(int playerNumber, int dice1, int dice2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }
  
 
  @Then("^Player (\\d+) move the rolled number of squares$")
  public void player_move_the_rolled_number_of_squares(int playerNumber, 
      int dice1, int dice2) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    int oldPosition = player.getPosition();
    player.move(dice1, dice2);
    int newPosition = player.getPosition();
    assertNotEquals(old_position, new_position);
  }

//////////////////////////////////////////////////////////////////////////////////
  //TODO need remaining jail time to be figured out
  @Given("^Player (\\d+) has been in jail for (\\d+) turns$")
  public void player_has_been_in_jail_for_turns(int playerNumber, int jail_time) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    player.setJail(true);
    
    throw new PendingException();
  }


  @When("^player (\\d+) rolls a (\\d+) and a (\\d+)$")
  public void player_rolls_a_and_a(int arg1, int arg2, int arg3) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^Player (\\d+) is on Old Kent Road$")
  public void player_is_on_Old_Kent_Road(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^Player (\\d+) loses £(\\d+) so they have £(\\d+) left$")
  public void player_loses_so_they_have_left(int arg1, int arg2, int arg3) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

//////////////////////////////////////////////////////////////////////////////////
  //pay 50 to leave jail
  @Given("^Player (\\d+) has been in jail less then three turns$")
  public void player_has_been_in_jail_less_then_three_turns(int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    player.setJail(true);
  }

  @Given("^Player (\\d+) has$")
  public void player_has(int playerNumber, int totalmoney) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    player.setMoney(1000);
  }

  //What to do here?
  @When("^Player (\\d+) wants to leave$")
  public void player_wants_to_leave(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }
 
  //need function for paying out of jail
  @Then("^Player (\\d+) must lose (\\d+) so they have (\\d+)$")
  public void player_must_lose_so_they_have(int playerNumber, int arg2, int arg3) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    int money = 1000;
    player.subtractMoney(50);
    player.setJail(false);
    assertEquals(money-50, player.getMoney());
  }

//////////////////////////////////////////////////////////////////////////////////
  // roll double 3 times in a row to jail
  @Given("^Player (\\d+) rolls doubles three times in a row$")
  public void player_rolls_doubles_times_in_a_row(int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    player.setDoubles(3);
  }

  @Then("^Player (\\d+) should go to jail$")
  public void player_should_go_to_jail(int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    GoToJail goToJail = new GoToJail();
    goToJail.sentToJail(player);
    boolean inJail = player.jailCheck();
    assertEquals(injail, true);
  }

///////////////////////////////////////////////////////////////////////////////////
  //roll double 3 times in a row do not collect
  @Given("^Player (\\d+) rolls doubles three times in a row$")
  public void player_rolls_doubles_time_in_a_row(int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    player.setDoubles(3);
    player.setMoney(1000);
    GoToJail goToJail = new GoToJail();
    goToJail.sentToJail(player);
  }
  
  @Then("^Player (\\d+) should not gain money and they have (\\d+)$")
  public void player_should_not_collect_pounds(int playerNumber, int money ) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    assertEquals(money, player.getMoney());
  }

//////////////////////////////////////////////////////////////////////////////////
  // player buys unowned property and get it (no money)
  @Given("^Player (\\d+) lands on an unowned property named Whitechapel Road$")
  public void player_lands_on_an_unowned_property_named_whitechapel_road
  (int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    player.setPosition(3);
    player.setMoney(300);
  }

  // ? What here
  @When("^player (\\d+) decides to buy it$")
  public void player_decides_to_buy_it(int playerNumber) throws Throwable {
    throw new PendingException();
  }

  //set owner should check money
  @Then("^owns the property$")
  public void owns_the_property(int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    player.setMoney(1000);
    Property whitechapel_road = new Property("Whitechapel Road", 3, 60, 4, 0, 50, "red");
    whitechapel_road.setOwner(player.getName()); 
    assertEquals(whitechapel_road.getOwner(), player.getName());
  }

//////////////////////////////////////////////////////////////////////////////////
  // don't buy property but land on it
  @Given("^Player (\\d+) lands on an unowned property named Coventry Street$")
  public void player_lands_on_an_unowned_property_named_Coverntry_Street
  (int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    player.setPosition(27);
  }+

  @When("^Player (\\d+) decides that they don't want it$")
  public void player_decides_that_they_don_t_want_it(int arg1) throws Throwable {
    throw new PendingException();
  }

  @Then("^Coventry Street remains unowned$")
  public void coventry_Street_remains_unowned() throws Throwable {
    Property coventry_street = new Property("Coventry Street", 27, 260, 22, 0, 150, "yellow");
    assertEquals(coventry_street.getOwner(), "");
  }

//////////////////////////////////////////////////////////////////////////////////
  // player can't afford property
  @Given("^Player (\\d+) lands on an unowned property named Leicester Square$")
  public void player_lands_on_unowned_property_Leicester_Square(int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    player.setPosition(26);
  }

  @Given("^Player (\\d+) cannot afford it$")
  public void player_cannot_afford_it(int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    player.setMoney(200);
    Property leicester_square = new Property("Leicester Square", 26, 260, 22, 0, 150, "yellow");
    leicester_square.setOwner(player.getName());
  }

  @Then("^Square shoulf remain unowned$")
  public void square_remains_unowned (int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    Property leicester_square = new Property("Leicester Square", 26, 260, 22, 0, 150, "yellow");
    leicester_square.setOwner(player.getName());
    assertEquals(leicester_square.getOwner(), "");
  }

//////////////////////////////////////////////////////////////////////////////////
  // pay rent receiver gets money
  @Given("^Player (\\d+) lands on an owned property$")
  public void player_lands_on_an_owned_property(int playerNumber) throws Throwable {
    Player player1 = testGame.players.get(playerNumber);
    player1.setPosition(26);
  }

  @Then("^Player (\\d+) should pay rent to player (\\d+)$")
  public void player_should_pay_rent_to_player 
  (int playerNumber1, int playerNumber2) throws Throwable {
    Player player1 = testGame.players.get(playerNumber1);
    Player player2 = testGame.players.get(playerNumber2);
    Property leicester_square = new Property("Leicester Square", 26, 260, 22, 0, 150, "yellow");
    leicester_square.setOwner(player2.getName());
    int old_money = player2.getMoney();
    player1.payRent(leicester_square.getRent(), player2);
    assertEquals(old_money, old_money + leicester_square.getRent());
  }
  
//////////////////////////////////////////////////////////////////////////////////
  // pay rent payer loses money
  @Given("^Player (\\d+) lands on an owned property$")
  public void player_lands_on_owned_property(int playerNumber) throws Throwable {
    Player player1 = testGame.players.get(playerNumber);
    player1.setPosition(26);
  }
+
  @Then("^Player (\\d+) should pay rent to player (\\d+)$")
  public void player_should_lose_money_to_player 
  (int playerNumber1, int playerNumber2) throws Throwable {
    Player player1 = testGame.players.get(playerNumber1);
    Player player2 = testGame.players.get(playerNumber2);
    Property leicester_square = new Property("Leicester Square", 26, 260, 22, 0, 150, "yellow");
    leicester_square.setOwner(player2.getName());
    int old_money = player1.getMoney();
    player1.payRent(leicester_square.getRent(), player2);
    assertEquals(old_money, old_money - leicester_square.getRent());
  }

//////////////////////////////////////////////////////////////////////////////////
  //TODO need to finish houses function first
  // check if house increases rent
  @Given("^Player (\\d+) has a house on Old Kent Road$")
  public void player_has_a_house_on_Old_Kent_Road
  (int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);    
    Property old_kent_road = new Property("Old Kent Road", 1, 60, 2, 1, 50, "red");
    throw new PendingException();
  }

  @When("^Player (\\d+) lands on Old Kent Road  property$")
  public void player_lands_on_Old_Kent_Road_property(int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);
    throw new PendingException();
  }

  @Then("^Player (\\d+) should pay £(\\d+) to Player (\\d+)$")
  public void player_should_pay_to_Player(int arg1, int arg2, int arg3) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

//////////////////////////////////////////////////////////////////////////////////
  //TODO need to see how code will work
  @Given("^a player ownes all three properties of a single color$")
  public void player_ownes_all_three_properties_of_a_single_color() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @When("^they have enough money for a house$")
  public void they_have_enough_money_for_a_house() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^they may pay the bank to get a house on one property$")
  public void they_may_pay_the_bank_to_get_a_house_on_one_property() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

///////////////////////////////////////////////////////////////////////////////////
  //check hotel  is 5 houses
  @Given("^a player (\\d+) already has four houses on Regent Street$")
  public void player_already_has_houses_on_Regent_Street(int arg1) throws Throwable {
    Player player = testGame.players.get(playerNumber);    
    Property regent_street = new Property("Regent Street", 31, 300, 26, 0, 200, "green");
  }

  @Then("^player (\\d+) may purchase a hotel on the property$")
  public void they_may_purchase_a_hotel_on_the_property_for
  (int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);    
    Property regent_street = new Property("Regent Street", 31, 300, 26, 0, 200, "green");
    regent_street.addHouse(4);
    regent_street.addHouse(1);
    assertEquals(regent_street.getNumOfHouses(), 5);
  }

////addMoney///////////////////////////////////////////////////////////////////////////////
  
  @Given("^a player (\\d+) already has four houses on Regent Street$")
  public void player_already_has_five_houses_on_Regent_Street(int arg1) throws Throwable {
    Player player = testGame.players.get(playerNumber);    
    Property regent_street = new Property("Regent Street", 31, 300, 26, 0, 200, "green");
  }

  @Then("^player (\\d+) may not purchase a hotel on the property$")
  public void they_may_not_purchase_a_hotel_on_the_property_for(int playerNumber) throws Throwable {
    Player player = testGame.players.get(playerNumber);    
    Property regent_street = new Property("Regent Street", 31, 300, 26, 0, 200, "green");
    regent_street.addHouse(4);
    regent_street.addHouse(1);
    regent_street.addHouse(1);
    assertEquals(regent_street.getNumOfHouses(), 5);
  }
+
//////////////////////////////////////////////////////////////////////////////////
  //check if owner changes in mortgage
  @Given("^player (\\d+) lands on Mayfair(\\d+)$")
  public void player_has_and_lands_on_a_square_owned_by(int playerNumber1,
  int playerMoney, int playerNumber2) throws Throwable {
    Player player1 = testGame.players.get(playerNumber1);
    Player player2 = testGame.players.get(playerNumber2);    
    player1.setMoney(20);
    player1.setPosition(39);
    Property mayfair = new Property("Mayfair", 39, 400, 50, 0, 200, "purple");
    mayfair.setOwner(player2.getName());
  }
  
  //What to do here?
  @Given("^player (\\d+) cannot afford rent$")
  public void player_cannot_afford_rent$(int playerNumber) throws Throwable {
    throw new PendingException();

  }

  @Then("^player (\\d+) must mortgage their property in order to pay to player (\\d+)$")
  public void they_must_mortgage_their_property_in_order_to_pay(int playerNumber1,
      int playerNumber2) throws Throwable {
    Player player1 = testGame.players.get(playerNumber1);
    Player player2 = testGame.players.get(playerNumber2);
    Property bow_street = new Property("Bow Street", 16, 180, 14, 0, 90, "orange");
    bow_street.setOwner(player1.getName());
    bow_street.MortgageSquare(player1);
    assertEquals(bow_street.getOwner(), "");
  }

//////////////////////////////////////////////////////////////////////////////////
  // Bankrupt
  @Given("^Player (\\d+) does not own any properties$")
  public void player_does_not_own_any_properties
  (int playerNumber) throws Throwable {
    Player player1 = testGame.players.get(playerNumber);
  }

  @When("^Player (\\d+) cannot afford to pay rent to player (\\d+)$")
  public void player_cannot_afford_to_pay_rent_to_player
  (int playerNumber1, int playerNumber2) throws Throwable {
    Player player1 = testGame.players.get(playerNumber1);
    Player player2 = testGame.players.get(playerNumber2);
    player1.setMoney(30);
    Property mayfair = new Property("Mayfair", 39, 400, 50, 0, 200, "purple");
    mayfair.setOwner(player2.getName());
  }

  @Then("^player (\\d+) must give all of their money to player (\\d+)$")
  public void they_must_give_all_of_their_money_to_player(int playerNumber1, 
  int playerNumber2) throws Throwable {
    Player player1 = testGame.players.get(playerNumber1);
    Player player2 = testGame.players.get(playerNumber2);
    player2.setMoney(500);
    player1.payRent(50, player2);
    assertEquals(player2.getMoney(), 530);
  }

  //TODO no code to account for bankruptcy
  @Then("^player (\\d+) becomes bankrupt$")
  public void the_player_becomes_bankrupt() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

//////////////////////////////////////////////////////////////////////////////////
 
  @Given("^player (\\d+) owns Leicester Square$")
  public void player_owns_Leicester_Square(int playerNumber1) throws Throwable {
    Player player1 = testGame.players.get(playerNumber1);
    Property leicester_square = new Property("Leicester Square", 26, 260, 22, 0, 150, "yellow");
    leicester_square.setOwner(player1.getName());
  }

  @Given("^player (\\d+) owns Pall Mall$")
  public void player_owns_Pall_Mall(int playerNumber2) throws Throwable {
    Player player2 = testGame.players.get(playerNumber2);
    Property pall_mall= new Property("Pall Mall", 11, 140, 10, 0, 70, "pink");
    pall_mall.setOwner(player2.getName());
  }

  //??
  @Given("^both players wish to trade properties$")
  public void both_players_wish_to_trade_properties() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^player (\\d+) now owns Pall Mall and player (\\d+) now owns Leicester Square$")
  public void player_now_owns_Pall_Mall_and_player_now_owns_Leicester_Square(int playerNumber1,
  int playerNumber2) throws Throwable {
    Player player1 = testGame.players.get(playerNumber1);
    Player player2 = testGame.players.get(playerNumber2);
    Property leicester_square = new Property("Leicester Square", 26, 260, 22, 0, 150, "yellow");
    Property pall_mall= new Property("Pall Mall", 11, 140, 10, 0, 70, "pink");
    player1.tradeProperty(leicester_square, pall_mall, player2);
    assertEquals(pall_mall.getOwner(), player1.getName());
  }

//////////////////////////////////////////////////////////////////////////////////

  @Given("^Player (\\d+) owns Bond Street$")
  public void player_owns_Bond_Street(int playerNumber1) throws Throwable {
    Player player1 = testGame.players.get(playerNumber1);
    player1.setMoney(100);
    Property bond_street= new Property("Bond Street", 34, 320, 28, 0, 200, "green");
    bond_street.setOwner(player1.getName());
    
  }

  //??
  @When("^Player (\\d+) wishes to buy it(\\d+)$")
  public void player_wishes_to_buy_it(int playerNumber2) throws Throwable {
    Player player2 = testGame.players.get(playerNumber2);
    player2.setMoney(1000);
  }

  //??
  @When("^Player (\\d+) agrees$")
  public void player_agrees(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^Player (\\d+) owns Bond Street and Player (\\d+) gains £(\\d+)$")
  public void player_owns_Bond_Street_and_Player_gains(int playerNumber1, 
  int playerNumber2) throws Throwable {
    Player player1 = testGame.players.get(playerNumber1);
    Player player2 = testGame.players.get(playerNumber2);
    Property bond_street= new Property("Bond Street", 34, 320, 28, 0, 200, "green");
    player1.sellProperty(bond_street, 500, player2);
    assertEquals(player1.getMoney(), 600);
  }
  
//////////////////////////////////////////////////////////////////////////////////

  @Given("^Player (\\d+) owns Bond street$")
  public void player_owns_Bond_street(int playerNumber1) throws Throwable {
    Player player1 = testGame.players.get(playerNumber1);
    Property bond_street= new Property("Bond Street", 34, 320, 28, 0, 200, "green");
    bond_street.setOwner(player1.getName());

  }

  //??
  @When("^Player (\\d+) wishes to buy property(\\d+)$")
  public void player_wishes_to_buy_property(int playerNumber2) throws Throwable {
    Player player2 = testGame.players.get(playerNumber2);
    player2.setMoney(1000);
  }

  //??
  @When("^Player (\\d+) agrees to$")
  public void player_agrees_to(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^Player (\\d+) owns Bond Street and Player (\\d+) gains £(\\d+)$")
  public void player_owns_Bond_Street_and_Player_gain(int playerNumber1, 
      int playerNumber2) throws Throwable {
    Player player1 = testGame.players.get(playerNumber1);
    Player player2 = testGame.players.get(playerNumber2);
    Property bond_street= new Property("Bond Street", 34, 320, 28, 0, 200, "green");
    player1.sellProperty(bond_street, 500, player2);
    assertEquals(bond_street.getOwner(), player2.getName());
}
  //remove for testing 
   
   */
   
}



