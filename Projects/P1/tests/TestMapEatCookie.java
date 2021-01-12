import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapEatCookie {
	
	public void testMapEatCookie() {
		NoFrame frame = new NoFrame();
		PacMan pacman = frame.addPacMan(new Location(0, 1)); //Creates PacMan at location x, y
		assertTrue(pacman.consume() == null);
	}
}
