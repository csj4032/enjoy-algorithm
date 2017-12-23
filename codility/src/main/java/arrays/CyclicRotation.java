package arrays;

import java.util.Arrays;

public class CyclicRotation {

	public static int[] solution(int[] A, int K) {
		int len = A.length;
		int[] copy = new int[len];
		for (int i = 0; i < len; i++) {
			copy[(i + K) % len] = A[i];
		}
		return copy;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{3, 8, 9, 7, 6}, 3)));
	}
}
