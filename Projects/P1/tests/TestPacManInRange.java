import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManInRange extends TestCase {

	public void testPacManInRange() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		Ghost ghost = frame.addGhost(new Location(1, 1), "name", Color.red); //Creates a red ghost named "name" at location 0,0
		PacMan pacman = frame.addPacMan(new Location(2, 1)); //Creates PacMan at location 2,1
		assertTrue(ghost.is_pacman_in_range() == true);
	}
}
