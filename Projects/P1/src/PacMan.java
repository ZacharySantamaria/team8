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
		return null;
	}

	public boolean move() {
		ArrayList<Location> locations = this.get_valid_moves();
		if (this.is_ghost_in_range()) {
			for (Location l : locations) {
				if (myMap.getLoc(l).contains(Map.Type.GHOST)) {
					locations.remove(l);
				}
			}
		}
		if (locations.size() > 1 && prevLoc != null)
			locations.remove(prevLoc);
		if (locations == null || locations.size() == 0)
			return false;

		this.prevLoc = myLoc;
		this.myLoc = locations.get(0);

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
		if (here.contains(Map.Type.COOKIE)) {
			return myMap.eatCookie(myName);
		}
		return null;
	}
}
