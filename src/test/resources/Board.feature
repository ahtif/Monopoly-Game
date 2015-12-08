Feature: Movements

    Scenario: A player can make a single move
   		Given Player Boot started on the Bow Street square
		When Player Boot rolls a 2 and a 1
		Then Player Boot should be on Vine Street

    Scenario: A player rolls doubles
		Given Player Thimble started on the Go square
		When Player Thimble rolls a 2 and a 2
    		And Player Thimble rolls a 1 and a 3
    	Then Player Thimble should be on Chance1
   
	Scenario: A player lands on the Go To Jail square
		Given Player Car started on the Fleet Street square
        When Player Car rolls a 5 and a 2
        Then Player Car should be on Jail
        	And Player Car is in Jail
        	
    Scenario: A player passes Go
		Given Player Hat started on the Park Lane square
		When Player Hat rolls a 2 and a 3
		Then Player Hat should be on Community Chest1
			And Player Hat should gain 200 for passing Go
   
    Scenario: A player moves onto Jail but is not in Jail
		Given Player Ship started on the Kings Cross Station square
		When Player Ship rolls a 2 and a 3
		Then Player Ship should be on Jail
			And Player Ship is not in Jail
		

    Scenario: Players can take turns to move
        Given Player Car started on the Go square
          And Player Hat started on the Go square
        When Player Car rolls a 2 and a 4
        And Player Hat rolls a 1 and a 3
        Then Player Car should be on Kings Cross Station
         And Player Hat should be on Whitechapel Road    

    Scenario: A player lands on a chance square and gains money
		Given Player Dog started on the Old Kent Road square
		When Player Dog rolls a 1 and a 5
		Then Player Dog should be on Chance1
			And Player Dog should gain 100 for landing on Chance1
			
	Scenario: A player lands on a chance square and loses money
		Given Player Thimble started on the Marylebone Station square
		When Player Thimble rolls a 2 and a 5
		Then Player Thimble should be on Chance2
			And Player Thimble should lose 100 for landing on Chance2

    Scenario: A player lands on a community chest square
	Given Player Ship is on Whitechapel Road
	When Player Ship rolls an 8
	And lands on a Community Chest
	Then Player Ship should gain 50

   Scenario: A player is in Jail for 1 turn
	Given Player Dog is in jail and they have only rolled once
	When Player Dog rolls
	And the dice does not show the same number
	Then Player Dog should remain in Jail

    Scenario: A player rolls doubles in jail
	Given Player Dog is currently in Jail
	When Player Dog rolls doubles
	Then Player Dog move the rolled number of squares
		
    Scenario: A player has been in jail for 3 turns
	Given Player Boot has been in jail for 3 turns
	And Player Boot has 1000
	When player Boot rolls a 4 and a 5
	Then Player Boot is on Old Kent Road 
	And Player Boot loses 50 so they have 950 left

    Scenario: A player wishes to leave jail early
	Given Player Ship has been in jail less then three turns
	And Player Ship has 100
	When Player Ship wants to leave
	Then Player Ship must lose 50 so they have 50

    Scenario: A player has rolled doubles 3 times in a row
	Given Player Thimble rolls doubles 3 times in a row
	Then Player Thimble should go to jail
	And Player Thimble should not collect 200 pounds

    Scenario: A player lands on a property that is unowned
	Given Player Car lands on an unowned property named Coventry Street
	And Player Car has 300
	When player Car decides to buy it
	Then Player Car has 243 left 
	And owns the property

    Scenario: A player lands on an unowned property but doesn't want it
    Given Player lands on an unowned property named Coverntry Street
	And Player Car has 300
	When Player Car decides that they do not want it
	Then Coventry Street remains unowned

    Scenario: A player lands on a property that is unowned but cannot afford it
	Given Player Hat lands on an unowned property named Leicester Square
	And Player Hat cannot afford it
	Then their turn should end

    Scenario: A player lands on an owned property
	Given Player Dog lands on an owned property
	Then Player Dog should pay the cost of rent to the owner of the property
