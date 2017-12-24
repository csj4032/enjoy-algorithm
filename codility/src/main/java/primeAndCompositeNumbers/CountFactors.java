package primeAndCompositeNumbers;

public class CountFactors {

	public static void main(String[] args) {
		System.out.println(solution(1));
		System.out.println(solution(2));
		System.out.println(solution(24));
		System.out.println(solution(9));
		System.out.println(solution(25));
		System.out.println(solution(16));
		System.out.println(solution(2147483646));
	}

	public static int solution(int N) {
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
