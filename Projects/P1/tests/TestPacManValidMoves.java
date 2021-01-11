import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestPacManValidMoves extends TestCase {

	public void testPacManValidMoves() throws FileNotFoundException {
		NoFrame frame = new NoFrame();
		PacMan pacman = frame.addPacMan(new Location(1, 1));

		ArrayList<Location> ans = new ArrayList<>();
		ans.add(new Location(2, 1));
		ans.add(new Location(1, 2));
		assertEquals(ans, pacman.get_valid_moves());
	}
}
