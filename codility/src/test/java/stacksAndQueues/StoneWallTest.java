package stacksAndQueues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoneWallTest {

	@Test
	void solution() {
		StoneWall stoneWall = new StoneWall();
		stoneWall.solution(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8, 1});
	}
}