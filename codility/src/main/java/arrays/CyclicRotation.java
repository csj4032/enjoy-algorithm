package arrays;

public class CyclicRotation {

	public int[] solution(int[] A, int K) {
		int len = A.length;
		int[] copy = new int[len];
		for (int i = 0; i < len; i++) {
			copy[(i + K) % len] = A[i];
		}
		return copy;
	}
}