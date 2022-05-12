package levelTwo;

import java.util.Arrays;

public class ArrayTruncation {

	public int[] solution(int n, long left, long right) {
		int length = (int) (right - left) + 1;
		int[] answer = new int[length];
		for (long i = left; i <= right; i++) {
			long j = (i % n) + 1;
			long k = (i / n) + 1;
			int index = (int) (i - left);
			answer[index] = (int) Math.max(k, j);
		}
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}
