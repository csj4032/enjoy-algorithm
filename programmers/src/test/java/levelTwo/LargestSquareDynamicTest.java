package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LargestSquareDynamicTest {

	public int solution(int[][] board) {
		LargestSquareDynamic largestSquare = new LargestSquareDynamic();
		return largestSquare.area(board);
	}

	@Test
	public void test() {
		Assertions.assertEquals(9, solution(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}}));
		Assertions.assertEquals(4, solution(new int[][]{{0, 0, 1, 1}, {1, 1, 1, 1}}));
		Assertions.assertEquals(1, solution(new int[][]{{1, 0}, {0, 0}}));
	}

}