import junit.framework.*;
import java.awt.Color;
import java.io.*;
public class TestMapMove {

	public void testMapMove() {
		NoFrame frame = new NoFrame();
		Location loc = new Location(1, 1);
		PacMan pacman = frame.addPacMan(loc);
		System.out.println(frame.getMap().move("pacman", new Location(1, 2), Map.Type.PACMAN));
  }
}
