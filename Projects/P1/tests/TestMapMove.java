import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapMove extends TestCase {

	public void testMapMove() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
		Location loc = new Location(1, 1);
		PacMan pacman = frame.addPacMan(loc);
		System.out.println(frame.getMap().move("pacman", new Location(1, 2), Map.Type.PACMAN));
		assertTrue(frame.getMap().move("pacman", new Location(1, 2), Map.Type.PACMAN));
	}
}
