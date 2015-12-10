Feature: Save and Load Game

	Scenario: Persist a game that has not started 
		Given we are having a game of monopoly
			And a player join the game as Boot
			And a player join the game as Car
		When we save the game as test-board-1
		Then the board has an id
		
	Scenario: Load a saved game 
		Given we load the saved game test-board-2
		Then player Dog should be on Kings Cross Station
		
	Scenario: Save a game, load another game, then return the first saved game 
		Given we are having a game of monopoly
			And a player joins the game as Thimble
			And Player Thimble rolls a 4 and a 5
			And we save the game as test-board-3
		When we load the saved game test-board-2
		And we load the saved game test-board-3
		Then player Thimble should be on Pentonville Road