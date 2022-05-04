package levelThree;

import java.util.Arrays;

public class IntegerTriangle {

	public int solution(int[][] triangle) {
		int max = 0;
		int length = triangle.length + 1;
		int[][] square = new int[length][length + 1];
		for (int i = 0; i < length; i++) {
			Arrays.fill(square[i], 0);
			if (i <= 0) continue;
			int row = triangle[i - 1].length;
			int[] rows = triangle[i - 1];
			for (int j = 0; j < row; j++) {
				square[i][j + 1] = rows[j];
			}
		}
		for (int i = 1; i < length; i++) {
			for (int j = 1; j < length; j++) {
				int result1 = square[i][j] + square[i - 1][j];
				int result2 = square[i][j] + square[i - 1][j - 1];
				square[i][j] = Math.max(result1, result2);
				max = Math.max(max, square[i][j]);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[][] triangle = new int[][]{
				new int[]{7},
				new int[]{3, 8},
				new int[]{8, 1, 0},
				new int[]{2, 7, 4, 4},
				new int[]{4, 5, 2, 6, 5}
		};
		IntegerTriangle integerTriangle = new IntegerTriangle();
		System.out.println(integerTriangle.solution(triangle));
	}
}
