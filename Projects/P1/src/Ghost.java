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
	
		//check going right
		Location shifted = myLoc.shift(1, 0);
		if(!myMap.getLoc(shifted).contains(Map.Type.WALL)) {
			valid_moves.add(shifted);
		}
		
		//check going left
		shifted = myLoc.shift(-1, 0);
		if(!myMap.getLoc(shifted).contains(Map.Type.WALL)) {
			valid_moves.add(shifted);
		}
		
		//check going up
		shifted = myLoc.shift(0, -1);
		if(!myMap.getLoc(shifted).contains(Map.Type.WALL)) {
			valid_moves.add(shifted);
		}
		
		//check going down
		shifted = myLoc.shift(0, 1);
		if(!myMap.getLoc(shifted).contains(Map.Type.WALL)) {
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
		Location testLeft = myLoc.shift(-1,0);
		Location testRight = myLoc.shift(1,0);
		Location testDown = myLoc.shift(0,1);
		Location testUp = myLoc.shift(0,-1);

		//Hardcoding these options, I can't think of a clean way to do this rn
		HashSet<Map.Type> here = myMap.getLoc(testLeft);
		//null check
		if (here == null){
			if (here.contains(Map.Type.PACMAN)){
				return true;
			}
			here = myMap.getLoc(testRight);
			if (here.contains(Map.Type.PACMAN)){
				return true;
			}
			here = myMap.getLoc(testUp);
			if (here.contains(Map.Type.PACMAN)){
				return true;
			}
			here = myMap.getLoc(testDown);
			if (here.contains(Map.Type.PACMAN)){
				return true;
			}
		}
		
		//No adjacent location has pacman
		return false;
	}

	public boolean attack() {
		if (is_pacman_in_range() == true) {
			myMap.attack(myName);
			return true;
		}
		return false;
	}
}
