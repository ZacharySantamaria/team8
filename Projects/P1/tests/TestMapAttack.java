import java.awt.Color;
import junit.framework.*;

public class TestMapAttack extends TestCase{

	public void testMapAttack() {
		try{
		NoFrame frame = new NoFrame();
		Location pacman_loc = new Location(1, 1);
		Location ghost_loc = new Location(2,1);
		PacMan p = frame.addPacMan(pacman_loc);
		Ghost g = frame.addGhost(ghost_loc, "ghost", Color.red); 
		Map m = frame.getMap();
		boolean result = m.attack("ghost");
		assertEquals(result, true);
	}
	catch(Exception e) {
		assertTrue(5==4);
	}
}
}
