import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCases {

	@Test
	public void testBoard1() {
		Board b1 = new Board(5, 6);
		int Traversal = b1.executecommands(new String[] { "l1", "r2", "b2" });
		assertEquals(2, Traversal);

	}

	@Test
	public void testBoard2() {
		Board b2 = new Board(500, 600);
		int Traversal = b2.executecommands(new String[] { "l3", "f100", "R2", "F200" });
		assertEquals(100, Traversal);
	}

	@Test
	public void testBoard3() {
		Board b3 = new Board(5000, 6000);
		int Traversal = b3.executecommands(new String[] { "l3", "f1000", "R3", "F2000" });
		assertEquals(3000, Traversal);

	}

	@Test
	public void testBoard4() {
		Board b4 = new Board(200, 90000);
		int Traversal = b4
				.executecommands(new String[] { "l1", "f4000", "l50", "b35", "r3", "f75", "l14", "B10", "r7", "F700" });
		assertEquals(3420, Traversal);

	}
	
	@Test
	public void testBoard5() {
		Board b4 = new Board(400, 90000);
		int Traversal = b4
				.executecommands(new String[] { "l1", "f4000", "l50", "b35", "r3", "f75", "l14", "B100", "r7", "F8000" });
		assertEquals(4140, Traversal);

	}

}
