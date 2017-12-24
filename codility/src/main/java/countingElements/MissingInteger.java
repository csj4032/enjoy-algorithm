package countingElements;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {

	public static int solution(int[] A) {
		Set<Integer> set = new HashSet<>();
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			set.add(A[i]);
			if (max < A[i]) max = A[i];
		}

		for (int i = 1; i <= max; i++) {
			if (!set.contains(i)) return i;
		}

		return max + 1;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[]{1, 3, 6, 4, 1, 2}));
	}
}
