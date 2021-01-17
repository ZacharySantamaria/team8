import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManMove extends TestCase {

	public void testPacManMove() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		Location loc = new Location(3, 21);
		PacMan pacman = frame.addPacMan(loc); 
		for(int i = 0; i < 19; i++) {
			pacman.move();
		}
		assertEquals(pacman.myLoc, new Location(2,3));
		for(int i = 0; i < 9; i++) {
			pacman.move();
		}
		assertEquals(pacman.myLoc, new Location(1,11));
		pacman.move();
		assertEquals(pacman.myLoc, new Location(1,10));
	}
}
