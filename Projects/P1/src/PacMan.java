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
		if(this.is_ghost_in_range){
			for(Location l: locations){
				if(map.getLoc(l).contains(Map.Type.GHOST)){
					locations.remove(l);
				}
			}
		}
		if(locations.size() > 1 && prevLoc != null){
			locations.remove(l);
		}		
		if (locations.size() == 0)
			return false;
		
		this.prevLoc = this.myLoc;
		this.myLoc = locations.get(0);
		this.myMap.move(myName, myLoc, Map.Type.PACMAN);
		
		return true;

	}

	public boolean is_ghost_in_range() { 
		Location up = this.myLoc.shift(0, 1);
		this.myLoc = this.myLoc.unshift(up);

		Location down = this.myLoc.shift(0, -1);
		this.myLoc = this.myLoc.unshift(down);

		Location left = this.myLoc.shift(-1, 0);
		this.myLoc = this.myLoc.unshift(left);

		Location right = this.myLoc.shift(1, 0);
		this.myLoc = this.myLoc.unshift(right);

		Location upright = this.myLoc.shift(1, 1);
		this.myLoc = this.myLoc.unshift(upright);

		Location downright = this.myLoc.shift(1, -1);
		this.myLoc = this.myLoc.unshift(downright);

		Location upleft = this.myLoc.shift(-1, 1);
		this.myLoc = this.myLoc.unshift(upleft);

		Location downleft = this.myLoc.shift(-1, -1);
		this.myLoc = this.myLoc.unshift(downleft);

		if (myMap.getLoc(up).contains(Map.Type.GHOST) || myMap.getLoc(down).contains(Map.Type.GHOST)
				|| myMap.getLoc(left).contains(Map.Type.GHOST) || myMap.getLoc(right).contains(Map.Type.GHOST)
				|| myMap.getLoc(upright).contains(Map.Type.GHOST) || myMap.getLoc(downright).contains(Map.Type.GHOST)
				|| myMap.getLoc(upleft).contains(Map.Type.GHOST) || myMap.getLoc(downleft).contains(Map.Type.GHOST)) {
			return true;
		}
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
