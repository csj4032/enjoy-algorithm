package maximumSliceProblem;

public class MaxProfit {

	public int solution(int[] A) {
		int min = 400001;
		int max = 0;
		int gap = 0;
		int index = 0;
		for (int i = 0; i < A.length; i++) {
			if (min > A[i]) {
				min = A[i];
				index = i;
			}
		}

		for (int i = 1; i < A.length; i++) {
			if (gap < A[i] - A[i - 1]) {
				gap = A[i] - A[i - 1];
			}
		}

		for (int i = index; i < A.length; i++) {
			if (max < A[i] - min) {
				max = A[i] - min;
			}
		}
		return Math.max(max, gap);
	}
}