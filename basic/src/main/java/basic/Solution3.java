package basic;

import java.util.Arrays;
import java.util.List;

import static com.google.common.primitives.Ints.asList;

public class Solution3 {

	public static int solution(int[] A, int X, int Y, int Z) {
		int result = 0;
		int length = A.length;
		List<Integer> list = asList(A);
		int index = 0;
		//int index = 0;

		while (true) {
			if (X > 0) {
				X = X - A[index % length];
				index++;
			} else {
			 break;
			}

		}

		return index;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[]{2, 8, 4, 3, 2}, 7, 11, 3));
		//System.out.println(solution(new int[]{5}, 4, 0, 3));
	}
}
