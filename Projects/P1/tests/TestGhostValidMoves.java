import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostValidMoves extends TestCase {

	public void testGhostValidMoves() throws FileNotFoundException{
		NoFrame frame = new NoFrame();
		Location loc = new Location(1, 1);
		Ghost g = frame.addGhost(loc, "ghost", Color.red); 
		ArrayList<Location> result = g.get_valid_moves();
		ArrayList<Location> valid_moves = new ArrayList<>();
		valid_moves.add(new Location(2,1));
		valid_moves.add(new Location(1,2));		
		assertEquals(result, valid_moves);
	}
}
