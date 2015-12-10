Feature: Things dealing with  money
    Scenario: A player lands on an owned property
    	Given Player Boot started on the Go square
			And Player Boot owns Old Kent Road
			And Player Car started on the Park Lane square
			And Player Car has 200 
			And Player Boot has 200 
    	When Player Car rolls a 2 and a 2
    	Then Player Car should be on Old Kent Road
    		And Player Car owes 2 rent to Player Boot
    		And Player Car should have 198
    		And Player Boot should have 202


