package elevenStreet.test01;

public class Solution2 {

	public int solution(int[] A) {
		int length = A.length;
		int max = -1000000001;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				int k = A[i] + A[j];
				int q = Math.abs(i-j);
				max = Math.max(k + q, max);
			}
		}
		return max;
	}
}