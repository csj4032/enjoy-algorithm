package levelTwo;

import org.junit.jupiter.api.Test;

class MatrixMultiplicationTest {

	public int[][] solution(int[][] arr1, int[][] arr2) {
		MatrixMultiplication matrixMultiplication = new MatrixMultiplication();
		int[][] answer = matrixMultiplication.calculator(arr1, arr2);
		return answer;
	}

	@Test
	public void test() {
		//solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}});
		solution(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, new int[][]{{5, 4, 3, 1}, {2, 4, 1, 2}, {3, 1, 1, 3}});
	}
}