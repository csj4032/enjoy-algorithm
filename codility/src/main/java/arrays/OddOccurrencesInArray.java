package arrays;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {

	public int solution(int[] A) {
		int temp = 0;
		for (int i = 0; i < A.length; i++) {
			temp = temp ^ A[i];
		}
		return temp;
	}

	public int solution2(int[] A) {
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
		OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
		System.out.println(oddOccurrencesInArray.solution(new int[]{9, 3, 9, 3, 9, 7, 9}));
		System.out.println(oddOccurrencesInArray.solution2(new int[]{9, 3, 9, 3, 9, 7, 9}));
	}
}