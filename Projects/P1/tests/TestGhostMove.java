import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostMove extends TestCase {

	public void testGhostMove() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		Location loc = new Location(1, 1);
		PacMan pacman = frame.addPacMan(loc);
		Ghost ghost = frame.addGhost(new Location(1, 2), "ghost", Color.GREEN);
		System.out.println(ghost.move());
	}
}
