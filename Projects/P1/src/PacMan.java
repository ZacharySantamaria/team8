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
		return null;	
	}

	public boolean move() {
		ArrayList<Location> locations = this.get_valid_moves();
		if(this.is_ghost_in_range()) {
			for(Location l: locations) {
				if(myMap.getLoc(l).contains(Map.Type.GHOST)) {
					locations.remove(l);
				}
			}
		}
		if(locations.size() > 1 && prevLoc != null) locations.remove(prevLoc);
		if(locations == null || locations.size() == 0) return false;
		
		this.prevLoc = myLoc;
		this.myLoc = locations.get(0);
		
		return true;
	}

	public boolean is_ghost_in_range() { 
		return false;
	}

	public JComponent consume() { 
 		return null;
	}
}
