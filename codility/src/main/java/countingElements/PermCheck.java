package countingElements;

import java.util.HashSet;
import java.util.Set;

public class PermCheck {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{1, 3, 2, 4, 6}));
	}

	public static int solution(int[] A) {
		Set set = new HashSet<>();
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			if (!set.add(A[i])) return 0;
			if (max < A[i]) max = A[i];
		}

		for (int i = 1; i <= max; i++) {
			if (!set.contains(i)) return 0;
		}

		return 1;
	}
}
