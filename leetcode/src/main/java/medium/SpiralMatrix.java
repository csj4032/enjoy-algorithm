package medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		int len = matrix.length * matrix.length;
		int count = 0;
		int left = 0;
		int right = matrix[0].length;
		int top = 0;
		int bottom = matrix.length;
		System.out.println(right);
		while (count < len) {
			for (int i = left; i < right; i++) {
				result.add(matrix[top][i]);
			}
			for (int i = top + 1; i < bottom; i++) {
				result.add(matrix[i][right - 1]);
			}
			for (int i = right - 1; i >= left; i--) {
				result.add(matrix[bottom - 1][i]);
			}
			for (int i = bottom - 1; i > top; i--) {
				result.add(matrix[i][left]);
			}
			left++;
			right--;
			top++;
			bottom--;
			count++;
		}
		System.out.println(result);
		return result;
	}
}
