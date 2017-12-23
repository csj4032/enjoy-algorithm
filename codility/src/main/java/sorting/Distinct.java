package sorting;

import java.util.HashSet;

public class Distinct {

	public static int solution(int[] A) {
		HashSet set = new HashSet();
		for (int i = 0; i < A.length; i++) {
			set.add(A[i]);
		}
		return set.size();
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[]{2, 1, 1, 2, 3, 1}));
	}
}