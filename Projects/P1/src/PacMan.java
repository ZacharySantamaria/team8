import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;

public class PacMan {
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

		return moves; // fixed error should bee checking for COOKIES || EMPTY
	}

	public boolean move() {
		ArrayList<Location> locations = this.get_valid_moves();
		// remove ghost locations so go the the directions have no ghost
		if (this.is_ghost_in_range()) {
			for (Location l : locations) {
				if (myMap.getLoc(l).contains(Map.Type.GHOST)) {
					locations.remove(l);
				}
			}
		}

		// remove the prevLoc when there is other options So the PacMan will not go back
		if (this.prevLoc != null) {
			locations.remove(prevLoc);
		}

		// if no place to go return false and do nothing
		if (locations.size() == 0)
			return false;

		this.prevLoc = this.myLoc;
		this.myLoc = locations.get(0);
		this.myMap.move(myName, myLoc, Map.Type.PACMAN);

		return true;

	}

	public boolean is_ghost_in_range() {
		Location up = this.myLoc.shift(0, 1);

		Location down = this.myLoc.shift(0, -1);

		Location left = this.myLoc.shift(-1, 0);

		Location right = this.myLoc.shift(1, 0);

		if (myMap.getLoc(up).contains(Map.Type.GHOST) || myMap.getLoc(down).contains(Map.Type.GHOST)
				|| myMap.getLoc(left).contains(Map.Type.GHOST) || myMap.getLoc(right).contains(Map.Type.GHOST)) {
			return true;
		}
		return false;
	}

	public JComponent consume() {
		HashSet<Map.Type> here = myMap.getLoc(myLoc);
		if (here != null && here.contains(Map.Type.GHOST)){
			return myMap.eatCookie(myName);
		}
		return null;
	}
}



