package prefixSums;

public class MinAvgTwoSlice {

	public static int solution(int[] A) {
		double min = (A[0] + A[1]) / 2;
		int result = 0;
		for (int i = 1; i < A.length; i++) {
			double avg = (A[i - 1] + A[i]) / 2;
			if (avg > min) {
				min = avg;
				result = i - 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[]{4, 2, 2, 5, 1, 5, 8}));
	}
}
