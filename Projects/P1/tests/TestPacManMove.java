import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManMove extends TestCase {

	public void testPacManMove() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		Location loc = new Location(1, 11);
		PacMan pacman = frame.addPacMan(loc); 
		pacman.move();
		assertEquals(pacman.myLoc, new Location(1,10));
		pacman.move();
		assertEquals(pacman.myLoc, new Location(1,9));
	}
}
