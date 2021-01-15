import java.awt.Color;
import java.io.FileNotFoundException;

import junit.framework.*;

public class TestGhostInRange extends TestCase {

	public void testGhostInRange() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
		Location loc = new Location(1, 1);
		PacMan pacman = frame.addPacMan(loc);
		Ghost ghost = frame.addGhost(new Location(1, 2), "ghost", Color.red);
		System.out.println(pacman.is_ghost_in_range());
		assertTrue(pacman.is_ghost_in_range());
	}
}
