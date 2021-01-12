import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;

public class Map {

	public enum Type {
		EMPTY, PACMAN, GHOST, WALL, COOKIE
	}

	private HashMap<Location, HashSet<Type>> field;
	private boolean gameOver;
	private int dim;

	private HashMap<String, Location> locations;
	private HashMap<String, JComponent> components;
	private HashSet<Type> emptySet;
	private HashSet<Type> wallSet;

	private int cookies = 0;

	public Map(int dim) {
		gameOver = false;
		locations = new HashMap<String, Location>();
		components = new HashMap<String, JComponent>();
		field = new HashMap<Location, HashSet<Type>>();

		emptySet = new HashSet<Type>();
		wallSet = new HashSet<Type>();
		emptySet.add(Type.EMPTY);
		wallSet.add(Type.WALL);
		this.dim = dim;
	}

	public void add(String name, Location loc, JComponent comp, Type type) {
		locations.put(name, loc);
		components.put(name, comp);
		if (!field.containsKey(loc))
			field.put(loc, new HashSet<Type>());
		field.get(loc).add(type);
	}

	public int getCookies() {
		return cookies;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public boolean move(String name, Location loc, Type type) {
		// update locations, components, and field
		// use the setLocation method for the component to move it to the new location
		if (locations.get(name) != null && field.get(name) != null) {
			locations.remove(name);
			locations.put(name, loc);
			field.remove(name);
			field.get(loc).add(type);
			return true;
		}
		return false;
	}

	public HashSet<Type> getLoc(Location loc) {
		if (loc.x > dim || loc.x < 0 || loc.y < 0 || loc.y > dim) {
			return new HashSet<Type>();
		}

		if (field.get(loc).contains(Map.Type.WALL))
			return wallSet;

		else if (field.get(loc).contains(Map.Type.EMPTY))
			return emptySet;

		else
			return field.get(loc);
	}

	public boolean attack(String Name) {
		// update gameOver
		this.gameOver = true;

		return true;
	}

	public JComponent eatCookie(String name) {
		// update locations, components, field, and cookies
		// the id for a cookie at (10, 1) is tok_x10_y1
		/*
		 * eatCookie should only be called by Pacman.consume, which checks if there's a
		 * cookie at pacman's location. Thus, this should work, but null condition added
		 * anyway 1. Identify where pacman is 2. remove cookie location 3. get cookie
		 * component 4. remove cookie from compoents 5. remove from field 6. return
		 * cookie component
		 */
		Location pacLoc = locations.get(name); // Current location where things taking place
		String cookieId = "tok_x" + pacLoc.x + "_y" + pacLoc.y;
		// Check if the cookieId is there or not. May fail if I messed up how cookieId
		// works
		if (locations.containsKey(cookieId) && components.containsKey(cookieId)) {
			cookies++;
			locations.remove(cookieId);
			JComponent retval = components.get(cookieId);
			components.remove(cookieId);
			field.get(pacLoc).remove(Map.Type.COOKIE);
			return retval; // The cookie component should be returned
		}
		return null; // Shouldn't happen? Just in case
	}
}
