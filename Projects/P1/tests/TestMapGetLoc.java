import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapGetLoc extends TestCase {

	public void testMapGetLoc() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
		assertTrue(frame.getMap().getLoc(new Location(9, 11)).contains(Map.Type.EMPTY));
		
	}
}
