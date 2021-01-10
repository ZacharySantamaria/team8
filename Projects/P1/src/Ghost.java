import java.util.HashSet;
import java.util.ArrayList;

public class Ghost {
	String myName;
	Location myLoc;
	Map myMap;
	Location prevLoc;

	public Ghost(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
		this.prevLoc = null;
	}

	public ArrayList<Location> get_valid_moves() {
		ArrayList<Location> valid_moves = new ArrayList<>();

		// check going right
		Location shifted = myLoc.shift(1, 0);
		if (!myMap.getLoc(shifted).contains(Map.Type.WALL)) {
			valid_moves.add(shifted);
		}

		// check going left
		shifted = myLoc.shift(-1, 0);
		if (!myMap.getLoc(shifted).contains(Map.Type.WALL)) {
			valid_moves.add(shifted);
		}

		// check going up
		shifted = myLoc.shift(0, 1);
		if (!myMap.getLoc(shifted).contains(Map.Type.WALL)) {
			valid_moves.add(shifted);
		}

		// check going down
		shifted = myLoc.shift(0, -1);
		if (!myMap.getLoc(shifted).contains(Map.Type.WALL)) {
			valid_moves.add(shifted);
		}

		return valid_moves;
	}

	public boolean move() {
		ArrayList<Location> locations = this.get_valid_moves();
		if (this.is_pacman_in_range()) {
			for (Location loc : locations) {
				if (myMap.getLoc(loc).contains(Map.Type.WALL)) {
					locations.remove(loc);
				}
			}
		}
		if (locations.size() > 1 && prevLoc != null) {
			locations.remove(prevLoc);
		}
		if (locations == null || locations.size() == 0) {

			return false;
		}
		this.prevLoc = myLoc;
		this.myLoc = locations.get(0);
		return true;
	}

	public boolean is_pacman_in_range() {
		return false;
	}

	public boolean attack() {
		return false;
	}
}
