package sorting;

import java.util.ArrayList;
import java.util.List;

public class MaxProductOfThree {

	private static int[] T = new int[2001];
	private static List<Integer> B = new ArrayList();
	private static int max = -1000 * -1000 * -1000;

	public static int solution(int[] A) {

		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				T[2001 - A[i]] += 1;
			} else {
				T[Math.abs(A[i])] += 1;
			}
		}

		for (int i = 0; i < T.length; i++) {
			if (T[i] != 0 && i <= 1000) {
				for (int j = 0; j < T[i]; j++) {
					B.add(i * -1);
				}
			} else if (T[i] != 0 && i > 1000) {
				for (int j = 0; j < T[i]; j++) {
					B.add(2001 - i);
				}
			}
		}

		for (int i = 2; i < B.size(); i++) {
			Integer multi = B.get(i - 2) * B.get(i - 1) * B.get(i);
			if (max < multi) max = multi;
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[]{-5, 5, -5, 4}));
		System.out.println(solution(new int[]{-3, 1, 2, -2, 5, 6}));
		System.out.println(solution(new int[]{10, 10, 10}));
		System.out.println(solution(new int[]{-1000, 500, -1}));
	}
}
