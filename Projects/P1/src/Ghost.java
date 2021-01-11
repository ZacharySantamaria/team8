import java.util.HashSet;
import java.util.ArrayList;

public class Ghost{
	String myName;
	Location myLoc;
	Map myMap;

	public Ghost(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	public ArrayList<Location> get_valid_moves() {
		return null;
	}

	public boolean move() {
		return false;
	}

	public boolean is_pacman_in_range() { 
		Location testLeft = myLoc.shift(-1,0);
		Location testRight = myLoc.shift(1,0);
		Location testDown = myLoc.shift(0,1);
		Location testUp = myLoc.shift(0,-1);

		//Hardcoding these options, I can't think of a clean way to do this rn
		HashSet<Map.Type> here = myMap.getLoc(testLeft);
		//null check
		if (here != null){
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
		return false;
	}
}
