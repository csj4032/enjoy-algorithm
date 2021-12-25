package levelTwo;

import java.util.Arrays;

public class MatrixMultiplication {

	public int[][] calculator(int[][] arr1, int[][] arr2) {
		int[][] arr3 = new int[arr1.length][];
		int n = arr1.length;
		int m = arr2[0].length;
		for (int i = 0; i < n; i++) {
			int b[] = new int[m];
			for (int j = 0; j < m; j++) b[j] = multiplication(arr1[i], arr2, j);
			arr3[i] = b;
		}
		System.out.println(Arrays.deepToString(arr3));
		return arr3;
	}

	private int multiplication(int a[], int[][] b, int k) {
		int c = 0;
		for (int i = 0; i < b.length; i++) {
			c += a[i] * b[i][k];
		}
		return c;
	}
}
