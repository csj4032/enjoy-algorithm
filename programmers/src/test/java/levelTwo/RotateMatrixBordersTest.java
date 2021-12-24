package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RotateMatrixBordersTest {

	public int[] solution(int rows, int columns, int[][] queries) {
		RotateMatrixBorders rotateMatrixBorders = new RotateMatrixBorders(rows, columns);
		int[] answer = rotateMatrixBorders.queries(queries);
		return answer;
	}

	@Test
	public void test() {
		Assertions.assertArrayEquals(new int[]{8, 10, 25}, solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}}));
	}
}