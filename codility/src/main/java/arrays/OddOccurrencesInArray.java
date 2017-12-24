package arrays;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {

	public static int solution(int[] A) {
		int temp = 0;
		for (int i = 0; i < A.length; i++) {
			temp = temp ^ A[i];
		}
		return temp;
	}

	public static int solution2(int[] A) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < A.length; i++) {
			if (!set.contains(A[i])) {
				set.add(A[i]);
			} else {
				set.remove(A[i]);
			}
		}
		return (int) set.toArray()[0];
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[]{9, 3, 9, 3, 9, 7, 9}));
		System.out.println(solution2(new int[]{9, 3, 9, 3, 9, 7, 9}));
	}
}