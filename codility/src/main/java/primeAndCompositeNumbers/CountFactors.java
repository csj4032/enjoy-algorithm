package primeAndCompositeNumbers;

public class CountFactors {

	public int solution(int N) {
		int count = 0;
		int end = (int) Math.sqrt(N);
		for (int i = 1; i <= end; i++) {
			if (N % i == 0) {
				count += 2;
			}
		}
		if ((end * end) == N) count -= 1;
		return count;
	}
}
