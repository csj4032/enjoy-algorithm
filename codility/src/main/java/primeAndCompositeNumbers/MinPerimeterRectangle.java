package primeAndCompositeNumbers;

public class MinPerimeterRectangle {

	public int solution(int N) {
		int end = (int) Math.sqrt(N);
		for (int i = end; i > 0; i--) {
			if (N % i == 0) {
				return (2 * (i + N / i));
			}
		}
		return 0;
	}
}