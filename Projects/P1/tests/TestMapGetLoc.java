import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapGetLoc extends TestCase {

	public void testMapGetLoc() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
		assert (frame.getMap().getLoc(new Location(12, 1)).contains(Map.Type.COOKIE));		
	}
}
