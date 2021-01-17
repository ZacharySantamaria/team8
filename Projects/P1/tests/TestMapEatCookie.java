import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapEatCookie extends TestCase{
	
	public void testMapEatCookie() {
		try{
			NoFrame frame = new NoFrame();
			PacMan pacman = frame.addPacMan(new Location(1, 1)); //Creates PacMan at location x, y
			assertTrue(pacman.consume() != null);
		}
		catch(Exception e){
			assertTrue(1==4);
		}
	}
}
