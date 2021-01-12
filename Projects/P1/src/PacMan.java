import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;

public class PacMan{
	String myName;
	Location myLoc;
	Location prevLoc;
	Map myMap;
	Location shift; 

	public PacMan(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.prevLoc = null;
		this.myName = name;
		this.myMap = map;
	}

	public ArrayList<Location> get_valid_moves() {
		ArrayList<Location> moves = new ArrayList<>();

		// checks for the position to the right the pacman
		if (myMap.getLoc(myLoc.shift(1, 0)).contains(Map.Type.COOKIE)
				|| myMap.getLoc(myLoc.shift(1, 0)).contains(Map.Type.EMPTY))
			moves.add(myLoc.shift(1, 0));

		// checks for the position above the pacman
		if (myMap.getLoc(myLoc.shift(0, 1)).contains(Map.Type.COOKIE)
				|| myMap.getLoc(myLoc.shift(0, 1)).contains(Map.Type.EMPTY))
			moves.add(myLoc.shift(0, 1));

		// checks for the position to the left the pacman
		if (myMap.getLoc(myLoc.shift(-1, 0)).contains(Map.Type.COOKIE)
				|| myMap.getLoc(myLoc.shift(-1, 0)).contains(Map.Type.EMPTY))
			moves.add(myLoc.shift(-1, 0));

		// checks for the position below the pacman
		if (myMap.getLoc(myLoc.shift(0, -1)).contains(Map.Type.COOKIE)
				|| myMap.getLoc(myLoc.shift(0, -1)).contains(Map.Type.EMPTY))
			moves.add(myLoc.shift(0, -1));

		return moves;
	}

	public boolean move() {
		ArrayList<Location> locations = this.get_valid_moves();

		if (locations.size() == 0)
			return false;
    
		this.myLoc = locations.get(0);
		this.myMap.move(myName, myLoc, Map.Type.PACMAN);
		
		return true;

	}

	public boolean is_ghost_in_range() { 
		return false;
	}

	public JComponent consume() { 
		HashSet<Map.Type> here = myMap.getLoc(myLoc);
		if (here != null && here.contains(Map.Type.COOKIE)){
			return myMap.eatCookie(myName);
		}
 		return null;
	}
}
