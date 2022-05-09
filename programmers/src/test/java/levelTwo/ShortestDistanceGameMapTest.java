package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShortestDistanceGameMapTest {

	@Test
	public void test() {
		ShortestDistanceGameMap shortestDistanceGameMap = new ShortestDistanceGameMap();
		Assertions.assertEquals(11, shortestDistanceGameMap.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
		Assertions.assertEquals(-1, shortestDistanceGameMap.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
	}
}

