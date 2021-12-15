package levelTwo;

import java.util.Arrays;

public class CreateMinimum {

	public long solution(int[] A, int[] B) {
		long answer = 0;
		Arrays.sort(A);
		Arrays.sort(B);
		for (int i = 0; i < A.length; i++) answer += A[i] * B[A.length - (i + 1)];
		return answer;
	}
}