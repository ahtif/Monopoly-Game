/*import cucumber.api.PendingException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
*/


public class Stepdefs {
/*  remove for testing
 
  @Before
  public void beforeScenario() {
    Board testBoard = new Board();
    Game testGame = new Game();
    testGame.name = "test-game-1";
    testGame.playersList.put(1, new Player(1, testBoard.square.get(0)));
    testGame.playersList.put(2, new Player(2, testBoard.square.get(0)));
    persistence.persistGame(testGame);
  }
  
  @After
  public void afterScenario() {
    Board testGame = persistence.findGameByName("test-game-1");
    persistence.removeGame(testBoard);
    persistence.removeGame(persistence.findGameByName("test-board-2"));
    persistence.removeGame(persistence.findGameByName("test-board-3"));
  }

  @Given("^Player (\\d+) started on the Go square$")
  public void player_started_on_the_Go_square(int playerNumber) throws Throwable {
    Player player = Game.players.get(playerNumber);
    player.setPosition(0);
  }

  @When("^a (\\d+) and a (\\d+) is rolled$")
  public void number_is_rolled(int dice1, int dice2) throws Throwable { // should be 6
    Player player = Game.players.get(playerNumber);
    player.move(dice1, dice2);
  }  
  
  @Then("^Player (\\d+) should be on (\\d+)$")
  public void player_should_be_on_Oxford_Street(int playerNumber, 
  int squareNumber) throws Throwable {
    Player player = Game.players.get(playerNumber);
    assertEquals(player.getPosition(), board.square.get(squareNumber));  pos = 6, sq = 6
  }
  
//////////////////////////////////////////////////////////////////////////////////

  @Given("^Player (\\d+) started on the Go square$")
  public void player_started_on_the_Go_square(int playerNumber) throws Throwable {
    Player player = Game.players.get(playerNumber);
    player.setPosition(0);
  }

  @When("^a (\\d+) and a (\\d+) are rolled and are the same number$")
  public void a_double_is_rolled(int dice1, int dice2) throws Throwable {
    Player player = Game.players.get(playerNumber);
    player.move(dice1, dice2);
  }

  @Then("^Player (\\d+) should be on (\\d+)$")
  public void player_should_be_on_oxford_Street(int playerNumber, 
  int squareNumber) throws Throwable {
    assertEquals(player.getPosition(), squareNumber);
  }

  @Then("^it should be Player (\\d+) turn again$")
  public void it_should_be_Player_turn_again(int playerNumber) throws Throwable {
    Player player = Game.players.get(playerNumber);
    int doubles = player.getDoubles();
    assertEquals(doubles, 1); // check that doubles has increased from 0 to 1
  }

//////////////////////////////////////////////////////////////////////////////////
 
  @Given("^Player (\\d+) has not been sent to Jail$")
  public void player_has_not_been_sent_to_Jail(int playerNumber) throws Throwable {
    Player player = Game.players.get(playerNumber);
  }

  @When("^Player (\\d+) land on the Jail Square$")
  public void player_land_on_the_Jail_Square(int arg1) throws Throwable {
    Player player = Game.players.get(playerNumber);
    player.setPosition(10);
  }

  @Then("^Player (\\d+) may leave on their next turn$")
  public void player_may_leave_on_their_next_turn(int playerNumber) throws Throwable {
    Player player = Game.players.get(playerNumber);
    assertEquals(player.jailCheck(), false);
  }
  

////////////////////////////////////////////////////////////////////////////////// 
 
  @Given("^Player (\\d+) starts their turn before the Go square$")
  public void player_starts_their_turn_before_the_Go_square(int playerNumber) throws Throwable {
    Player player = Game.players.get(playerNumber);
    player.setPosition(35);

  }

  @When("^Player (\\d+) lands on the Go square$")
  public void player_lands_on_the_Go_square(int playerNumber) throws Throwable {
    Player player = Game.players.get(playerNumber);
    player.move(3, 2);
  }

  @Then("^Player (\\d+) collect £(\\d+)$")
  public void player_collect(int arg1, int playerNumber) throws Throwable {
    Player player = Game.players.get(playerNumber);
    int old_money = player.getMoney();
    player.passGo();
    assertEquals(old_money+200, player.getMoney()); //check that player gained £200 
  }

//////////////////////////////////////////////////////////////////////////////////
   //HELP//
 
  
  @Given("^Player (\\d+) lands on the Go To Jail square$")
  public void player_lands_on_the_Go_To_Jail_square(int playerNumber) throws Throwable {
    Player player = Game.players.get(playerNumber);
    player.setPosition(30);
  }

  @Then("^Player (\\d+) should move directly to the Jail Square$")
  public void player_should_move_directly_to_the_Jail_Square(int playerNumber) throws Throwable {
    Player player = Game.players.get(playerNumber);
    Board board = new Board();
    //board.GoToJail.sentToJail(player);
  }

  @Then("^Player (\\d+) should not collect (\\d+)$")
  public void player_should_not_collect(int playerNumber, int goMoney, 
  int current_money) throws Throwable {
    Player player = Game.players.get(playerNumber);
    int money = player.getMoney();
    assertFalse(money, money+goMoney);

  }

//////////////////////////////////////////////////////////////////////////////////
 
  @Given("^PLayer (\\d+) is on Old Kent Road$")
  public void player_is_on_old_Kent_Road(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @When("^Player (\\d+) rolls a (\\d+)$")
  public void player_rolls_a(int arg1, int arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @When("^land on a chance square$")
  public void land_on_a_chance_square() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^Player (\\d+) gains £(\\d+)$")
  public void player_gains(int arg1, int arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

//////////////////////////////////////////////////////////////////////////////////
 
  @Given("^Player (\\d+) is on Whitechapel Road$")
  public void player_is_on_Whitechapel_Road(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @When("^Player (\\d+) rolls an (\\d+)$")
  public void player_rolls_an(int arg1, int arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @When("^lands on a Community Chest$")
  public void lands_on_a_Community_Chest() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^Player (\\d+) should gain £(\\d+)$")
  public void player_should_gain(int arg1, int arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

//////////////////////////////////////////////////////////////////////////////////
 
  @Given("^Player (\\d+) is in jail and they have only rolled once$")
  public void player_is_in_jail_and_they_have_only_rolled_once(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
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
 
  @Given("^Player (\\d+) is in Jail$")
  public void player_is_in_Jail(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }
  
  @When("^Player (\\d+) rolls doubles$")
  public void player_rolls_doubles(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^Player (\\d+) move the rolled number of squares$")
  public void player_move_the_rolled_number_of_squares(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

//////////////////////////////////////////////////////////////////////////////////

  @Given("^Player (\\d+) has been in jail for (\\d+) turns$")
  public void player_has_been_in_jail_for_turns(int arg1, int arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Given("^Player one has £(\\d+)$")
  public void player_one_has(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
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
 
  @Given("^Player (\\d+) has been in jail less then three turns$")
  public void player_has_been_in_jail_less_then_three_turns(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Given("^Player (\\d+) has £(\\d+)$")
  public void player_has(int arg1, int arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @When("^Player (\\d+) wants to leave$")
  public void player_wants_to_leave(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^Player (\\d+) must lose £(\\d+) so they have £(\\d+)$")
  public void player_must_lose_so_they_have(int arg1, int arg2, int arg3) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

//////////////////////////////////////////////////////////////////////////////////

  @Given("^Player (\\d+) rolls doubles (\\d+) times in a row$")
  public void player_rolls_doubles_times_in_a_row(int arg1, int arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^Player (\\d+) should go to jail$")
  public void player_should_go_to_jail(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^Player (\\d+) should not collect (\\d+) pounds$")
  public void player_should_not_collect_pounds(int arg1, int arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

//////////////////////////////////////////////////////////////////////////////////
 
  @Given("^Player (\\d+) lands on an unowned property named Coventry Street$")
  public void player_lands_on_an_unowned_property_named_Coventry_Street(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @When("^player (\\d+) decides to buy it$")
  public void player_decides_to_buy_it(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^Player (\\d+) has £(\\d+) left$")
  public void player_has_left(int arg1, int arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^owns the property$")
  public void owns_the_property() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

//////////////////////////////////////////////////////////////////////////////////
 
  @Given("^Player lands on an unowned property named Coverntry Street$")
  public void player_lands_on_an_unowned_property_named_Coverntry_Street() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @When("^Player (\\d+) decides that they don't want it$")
  public void player_decides_that_they_don_t_want_it(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^Coventry Street remains unowned$")
  public void coventry_Street_remains_unowned() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

//////////////////////////////////////////////////////////////////////////////////
 
  @Given("^Player (\\d+) lands on an unowned property named Leicester Square$")
  public void player_lands_on_unowned_property_Leicester_Square(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Given("^Player (\\d+) cannot afford it$")
  public void player_cannot_afford_it(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^their turn should end$")
  public void their_turn_should_end() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

//////////////////////////////////////////////////////////////////////////////////
 
  @Given("^Player (\\d+) lands on an owned property$")
  public void player_lands_on_an_owned_property(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^Player (\\d+) should pay the cost of rent to the owner of the property$")
  public void player_should_pay_the_cost_of_rent_to_the_owner_of_the_property(int arg1)
      throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

//////////////////////////////////////////////////////////////////////////////////
 
  @Given("^Player (\\d+) owns Old Kent Road$")
  public void player_owns_Old_Kent_Road(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Given("^Player (\\d+) lands on Old Kent Road$")
  public void player_lands_on_Old_Kent_Road(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^Player (\\d+) owes Player (\\d+) £(\\d+)$")
  public void player_owes_Player(int arg1, int arg2, int arg3) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

//////////////////////////////////////////////////////////////////////////////////
 
  @Given("^Player (\\d+) has a house on Old Kent Road$")
  public void player_has_a_house_on_Old_Kent_Road(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @When("^Player (\\d+) lands on Old Kent Road  property$")
  public void player_lands_on_Old_Kent_Road_property(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^Player (\\d+) should pay £(\\d+) to Player (\\d+)$")
  public void player_should_pay_to_Player(int arg1, int arg2, int arg3) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

//////////////////////////////////////////////////////////////////////////////////
 
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
 
  @Given("^a player already has (\\d+) houses on Regent Street$")
  public void player_already_has_houses_on_Regent_Street(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^they may purchase a hotel on the property for £(\\d+)$")
  public void they_may_purchase_a_hotel_on_the_property_for(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

//////////////////////////////////////////////////////////////////////////////////
 
  @Given("^a player has £(\\d+) and lands on a square in which the rent is £(\\d+)$")
  public void player_has_and_lands_on_a_square_in_which_the_rent_is(int arg1,
      int arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }
  
  @Given("^they have a property or a combination of properties that add up to £(\\d+)$")
  public void they_have_a_property_or_a_combination_of_properties_that_add_up_to(int arg1)
      throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^they must mortgage their property in order to pay to owner$")
  public void they_must_mortgage_their_property_in_order_to_pay_to_owner() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

//////////////////////////////////////////////////////////////////////////////////
 
  @Given("^Player (\\d+) cannot mortgage any properties$")
  public void player_cannot_mortgage_any_properties(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @When("^Player (\\d+) cannot aford rent of £(\\d+)$")
  public void player_cannot_afford_rent_of(int arg1, int arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^they must give all of their money to the owner of the property$")
  public void they_must_give_all_of_their_money_to_the_owner_of_the_property() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^the player becomes bankrupt$")
  public void the_player_becomes_bankrupt() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

//////////////////////////////////////////////////////////////////////////////////
 
  @Given("^player (\\d+) owns Leicester Square$")
  public void player_owns_Leicester_Square(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Given("^player (\\d+) owns Pall Mall$")
  public void player_owns_Pall_Mall(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Given("^both players wish to trade properties$")
  public void both_players_wish_to_trade_properties() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^player (\\d+) now owns Pall Mall and player (\\d+) now owns Leicester Square$")
  public void player_now_owns_Pall_Mall_and_player_now_owns_Leicester_Square(int arg1,
      int arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

//////////////////////////////////////////////////////////////////////////////////

  @Given("^Player (\\d+) owns Bond Street$")
  public void player_owns_Bond_Street(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @When("^Player (\\d+) wishes to buy it for £(\\d+)$")
  public void player_wishes_to_buy_it_for(int arg1, int arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @When("^Player (\\d+) agrees$")
  public void player_agrees(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^Player (\\d+) owns Bond Street and Player (\\d+) gains £(\\d+)$")
  public void player_owns_Bond_Street_and_Player_gains(int arg1, int arg2,
      int arg3) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }
  remove for testing */ 
}



