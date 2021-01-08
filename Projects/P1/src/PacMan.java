import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;

public class PacMan{
	String myName;
	Location myLoc;
	Map myMap;
	Location shift; 

	public PacMan(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	public ArrayList<Location> get_valid_moves() {
		
		ArrayList<Location> moves = new ArrayList<>();
		
		//checks for the position to the right the pacman
		if( myMap.getLoc(myLoc.shift(1,0)) == Map.Type.COOKIE || myMap.getLoc(myLoc.shift(1,0)) == Map.Type.EMPTY)
			moves.add(myLoc.shift(1,0));
	
		//checks for the position above the pacman
		if( myMap.getLoc(myLoc.shift(0,1)) == Map.Type.COOKIE || myMap.getLoc(myLoc.shift(0,1)) == Map.Type.EMPTY)
			moves.add(myLoc.shift(0,1));
	
		//checks for the position to the left the pacman
		if( myMap.getLoc(myLoc.unshift(1,0)) == Map.Type.COOKIE || myMap.getLoc(myLoc.unshift(1,0)) == Map.Type.EMPTY)
			moves.add(myLoc.unshift(1,0));
		
		//checks for the position below the pacman
		if( myMap.getLoc(myLoc.unshift(0,1)) == Map.Type.COOKIE || myMap.getLoc(myLoc.unshift(0,1)) == Map.Type.EMPTY)
			moves.add(myLoc.unshift(0,1));
	
		return moves;
	}

	public boolean move() {
		return false;
	}

	public boolean is_ghost_in_range() { 
		return false;
	}

	public JComponent consume() { 
 		return null;
	}
}
