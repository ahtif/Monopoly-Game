Feature: Things dealing with  money
/*	
    Scenario: A player lands on an owned property
	Given Player Boot owns Old Kent Road
    And Player Car lands on Old Kent Road
    Then Player Car owes Player Boot 2 pound
	
    Scenario: A player lands on a property with a house
	Given Player Car has a house on Old Kent Road	
	When Player Boot lands on Old Kent Road  property
	Then Player Car should pay 10 to Player Boot

	#Scenario: A player buys a house
		#Given a player ownes all three properties of a single color
	#When they have enough money for a house
	#Then they may pay the bank to get a house on one property

	#Scenario: A player wants to buy a hotel
		#Given a player already has 4 houses on Regent Street
	#Then they may purchase a hotel on the property for 1275

	#Scenario: A player lands an owned square and can only afford rent by mortgaging property
		#Given a player has 150 and lands on a square in which the rent is 200
	#And they have a property or a combination of properties that add up to 50 
	#Then they must mortgage their property in order to pay to owner

	#Scenario: A player lands on property and cannot afford rent and cannot mortgage anything
		#Given Player Boot cannot mortgage any properties
	#When Player Boot cannot aford rent of 100
	#Then they must give all of their money to the owner of the property
	#And the player becomes bankrupt

	#Scenario: Two players wish to trade properties
		#Given player Boot owns Leicester Square 
	#And player Car owns Pall Mall
	#And both players wish to trade properties
	#Then player Boot now owns Pall Mall and player Car now owns Leicester Square

	#Scenario: A owned property is bought off another player
		#Given Player Boot owns Bond Street
	#When Player Car wishes to buy it for 300
	#And Player Boot agrees
	#Then Player Car owns Bond Street and Player Boot gains 300 

	#Scenario: A player goes bankrupt and his properties are up for grabs
		#Given Player Boot goes bankrupt
	#Then the remaining players may bid on Player Boot properties

	#Scenario: A bankrupt player's property goes unbought
		#Given Picadilly is able to be bid on
	#When no player bids on it
	#Then it goes back to being an unowned square

	#Scenario: A bankrupt player's property is bought
		#Given Picadilly is able to be bid on
	#When Player Boot bids £400
	#And no other player wishes to pay that much
	#Then Player Boot loses £400
	#And Player Boot now ownes Picadilly
