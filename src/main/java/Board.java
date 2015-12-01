import java.util.ArrayList;

public class Board {

  // Data Members
  ArrayList<Square> squares;

  // Constructors
  /**
   * The constructor initialises all the squares on the board.
   */
  public Board() {
    squares = new ArrayList<Square>();
    squares.add(new Square("GO",0));
    squares.add(new Property("Old Kent Road",1,60,2,2,50,"brown"));
    squares.add(new CommunityChest("Community Chest",2));
    squares.add(new Property("Whitechapel Road",3,60,4,2,50,"brown"));
    squares.add(new Square("Income Tax",4));
    squares.add(new RailRoad("Kings Cross Station",5,200,25,2,100));
    squares.add(new Property("The Angel Islington",6,100,6,2,50,"light blue"));
    squares.add(new Chance("Chance",7));
    squares.add(new Property("Euston Road",8,100,6,2,50,"light blue"));
    squares.add(new Property("Pentonville Road",9,120,8,2,60,"light blue"));
    squares.add(new Jail("Jail",10));
    squares.add(new Property("Pall Mall",11,140,10,2,70,"pink"));
    squares.add(new Utility("Electric Company",12,150,30,4,75));
    squares.add(new Property("Whitehall",13,140,10,2,70,"pink"));
    squares.add(new Property("Northumberland Avenue",14,160,12,2,80,"pink"));
    squares.add(new RailRoad("Marylebone Station ",15,200,25,2,100));
    squares.add(new Property("Bow Street",16,180,14,2,90,"orange"));
    squares.add(new CommunityChest("Community Chest",17));
    squares.add(new Property("Marlborough Street ",18,180,14,2,90,"orange"));
    squares.add(new Property("Vine Street ",19,200,16,2,100,"orange"));
    squares.add(new Square("Free Parking",20));
    squares.add(new Property("Strand ",21,220,18,2,110,"red"));
    squares.add(new Chance("Chance",22));
    squares.add(new Property("Fleet Street ",23,220,18,2,110,"red"));
    squares.add(new Property("Trafalgar Square",24,240,20,2,120,"red"));
    squares.add(new RailRoad("Fenchurch St Station",25,200,25,2,100));
    squares.add(new Property("Leicester Square",26,260,22,2,150,"yellow"));
    squares.add(new Property("Coventry Street",27,260,22,2,150,"yellow"));
    squares.add(new Utility("Water Works",28,150,30,4,75));
    squares.add(new Property("Piccadilly",29,280,22,2,150,"yellow"));
    squares.add(new GoToJail("Go To Jail",30));
    squares.add(new Property("Regent Street",31,300,26,2,200,"green"));
    squares.add(new Property("Oxford Street",32,300,26,2,200,"green"));
    squares.add(new CommunityChest("Community Chest",33));
    squares.add(new Property("Bond Street",34,320,28,2,200,"green"));
    squares.add(new RailRoad("Liverpool St Station ",35,200,25,2,100));
    squares.add(new Chance("Chance",36));
    squares.add(new Property("Park Lane",37,350,35,2,175,"dark blue"));
    squares.add(new Square("Super Tax",38));
    squares.add(new Property("Mayfair",39,400,50,2,200,"dark blue"));
  }

}// End of Board class

