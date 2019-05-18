package countingElements;

public class MaxCounters {

	public int[] solution(int N, int[] A) {
		int[] result = new int[N];
		int max = 0;
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] <= N) {
				result[A[i] - 1] = Math.max(sum, result[A[i] - 1]);
				result[A[i] - 1] += 1;
				max = Math.max(max, result[A[i] - 1]);
			} else if (A[i] == N + 1) {
				sum = max;
			}
		}

		for (int i = 0; i < result.length; i++) {
			result[i] = Math.max(sum, result[i]);
		}

		return result;
	}
}