
public class Square {

	// Data members
	private String name;
	private int location;

	// Constructors
	public Square () {
		name = "";
		location = 0;
	}

	public Square (String name, int location) {
		this.name = name;
		this.location = location;
	}

	// Instance methods
	public String getName() {
		return name;
	}

	public int getLocation() {
		return location;
	}

}// End of Square class