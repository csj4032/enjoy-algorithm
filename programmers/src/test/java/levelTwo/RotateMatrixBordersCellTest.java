package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class RotateMatrixBordersCellTest {

	public int[] solution(int rows, int columns, int[][] queries) {
		RotateMatrixBordersCell rotateMatrixBordersCell = new RotateMatrixBordersCell(rows, columns);
		int[] answer = rotateMatrixBordersCell.queries(queries);
		System.out.println(Arrays.toString(answer));
		return answer;
	}

	@Test
	public void test() {
		Assertions.assertArrayEquals(new int[]{8, 10, 25}, solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}}));
	}

}