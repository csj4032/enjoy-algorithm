package fibonacciNumbers;

import java.util.Arrays;

public class Ladder {

	public static void main(String[] args) {
		solution(new int[]{4, 4, 5, 5, 1}, new int[]{3, 2, 4, 3, 1});
	}

	public static int[] solution(int[] A, int[] B) {
		int[] f = new int[A.length + 1];
		f[0] = 1;
		f[1] = 1;
		int MAX = 1 << 30;
		for (int i = 2; i < f.length; ++i) {
			f[i] = f[i - 1] + f[i - 2];
			f[i] = f[i] % MAX;
		}

		System.out.println(Arrays.toString(f));

		int[] res = new int[A.length];
		for (int i = 0; i < A.length; ++i) {
			System.out.println(f[A[i]] + " " + (1 << B[i]));
			res[i] = f[A[i]] % (1 << B[i]);
		}
		return res;
	}
}
