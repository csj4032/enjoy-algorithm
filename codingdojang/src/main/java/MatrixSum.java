import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class MatrixSum {

	private static int len = 15;
	private static int max = 0;
	private static int[][] matrix = new int[len][len];

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(MatrixSum.class.getResource("").getPath() + "MatrixSum.txt"));
		IntStream.range(0, len).forEach(i -> IntStream.range(0, len).forEach(j -> matrix[i][j] = sc.nextInt()));
		perm(0, len, IntStream.range(0, len).toArray());
		out.println(max);
	}

	private static void perm(int s, int n, int[] arr) {
		if (n == s) {
			max(arr);
			return;
		}

		for (int i = s; i < n; i++) {
			if (i != s) swap(i, s, arr);
			perm(s + 1, n, arr);
			if (i != s) swap(i, s, arr);
		}
	}

	private static void swap(int i, int s, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[s];
		arr[s] = temp;
	}

	private static void max(int[] arr) {
		int t = 0;
		for (int i = 0; i < len; i++) {
			t = t + matrix[i][arr[i]];
		}
		if (t > max) {
			out.println(max);
			max = t;
		}
	}
}