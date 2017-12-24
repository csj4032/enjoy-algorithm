package timeComplexity;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PermMissingElem {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{2, 3, 1, 5}));
	}

	private static int solution(int[] A) {
		return IntStream.rangeClosed(1, A.length + 1).sum() - Arrays.stream(A).sum();
	}
}