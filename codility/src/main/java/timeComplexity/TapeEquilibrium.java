package timeComplexity;

import java.util.Arrays;

public class TapeEquilibrium {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{1000, -1000}));
		System.out.println(solution(new int[]{-1000, 1000}));
		System.out.println(solution(new int[]{3, 1, 2, 4, 3}));
		System.out.println(solution(new int[]{-3, -1, -2, -4, -3}));
	}

	public static int solution(int[] A) {
		int right = Arrays.stream(A).sum();
		int left = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < A.length - 1; i++) {
			left += A[i];
			right -= A[i];
			min = Math.min(Math.abs(right - left), min);
		}
		return min;
	}
}
