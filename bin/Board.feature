Feature: Movements

    Scenario: Dice roll
	Given Player 1 rolls two dice
	When Player 1 rolls a 3 and a 5
	Then Player 1 should move 8 squares

    Scenario: A player rolls a 6
        Given Player 1 started on the Go square
	When a 6 is rolled
	Then Player 1 should be on Oxford Street

    Scenario: A player rolls doubles
	Given Player 2 started on the Go square
	When Player 2 rolls a 3 and a 3
	Then Player 2should end up on Oxford Street
	And it should be Player 2's turn again
   
    Scenario: A player moves onto Jail but isn't in Jail
	Given Player 1 has not been sent to Jail
	When PLayer 1 land on the Jail Square
	Then Player 1 may leave on their next turn

    Scenario: A player passes Go
	Given Player 2 starts their turn before the Go square
	When Player 2 lands on the Go square
	Then Player 2 collect £200

    Scenario: A player lands on the Go To Jail square
        Given Player 1 lands on the Go To Jail square
	Then Player 1 should move directly to the Jail Square
	And Player 1 should not collect £200

    (rewrite later) Scenario: A player lands on a chance square
	Given Player 1 lands on a chance square
	Then Player 1 should receive a chance card

    (rewrite later) Scenario: A player lands on a community chest square
	Given Player 1 lands on a community chest square
	Then Player 1 should receive a community chest card

   Scenario: A player is in Jail for 1 turn
	Given Player 1 is in jail and they have only rolled once
	When Player 1 rolls
	And the dice do not show the same number
	Then Player 1 should remain in Jail

    Scenario: A player rolls doubles in jail
	Given Player 2 rolls doubles while in jail
	Then Player 2 move the rolled number of squares
		
    Scenario: A player has been in jail for 3 turns
	Given Player 1 has been in jail for 3 turns
	When player 1 roll any number
	Then Player 1should the rolled number of squares

    Scenario: A player has rolled doubles 3 times in a row
	Given Player 1 rolls doubles 3 times in a row
	Then Player 1 should go to jail
	And Player 1 should not collect 200 pounds

    Scenario: A player lands on a property that is unowned
	Given Player lands on an unowned property
	And Player 1 can afford it
	Then Player 1 are able to buy the property if they wish

    Scenario: A player lands on a property that is unowned but cannot afford it
	Given Player 1 lands on an unowned property
	And Player 1 cannot afford it
	Then their turn should end

    Scenario: A player lands on an owned property
	Given Player 1 lands on an owned property
	Then Player 1 should pay the cost of rent to the player who ownes the property
