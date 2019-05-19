package maximumSliceProblem;

public class MaxSliceSum {

	public int solution(int[] A) {
		int length = A.length;
		int sum = -1000001;
		int max = -1000001;
		for (int i = 0; i < length; i++) {
			sum = Math.max(sum + A[i], A[i]);
			max = Math.max(sum, max);
		}
		return max;
	}
}