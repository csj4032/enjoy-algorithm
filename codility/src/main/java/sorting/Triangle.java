package sorting;

import java.util.Arrays;

public class Triangle {

	public static int solution(int[] A) {
		A = Arrays.stream(A).sorted().toArray();
		for (int i = 2; i < A.length; i++) {
			if (triangle(A[i - 2], A[i - 1], A[i])) return 1;
		}
		return 0;
	}

	private static boolean triangle(long p, long q, long r) {
		if ((p + q > r) && (p + r > q) && (r + q > p)) return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[]{10, 2, 5, 1, 8, 20}));
	}
}
