package prefixSums;

public class PassingCars {

	public static int solution(int[] A) {
		int length = A.length, zeroCount = 0, count = 0;
		for (int i = 0; i < length; i++) {
			if (A[i] == 0) {
				zeroCount++;
			} else {
				count += zeroCount;
			}
			if(count > 1000000000) return -1;
		}
		return count > 1000000000 ? -1: count;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[]{0, 1, 0, 1, 1}));
	}
}