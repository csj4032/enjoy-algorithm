package prefixSums;

public class CountDiv {

	public static int solution(int A, int B, int K) {
		return B / K - A / K + (A % K == 0 ? 1 : 0);
	}

	public static int solution2(int A, int B, int K) {
		int count = 0;
		for (int i = A; i <= B; i++) {
			if (i % K == 0) count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(solution(0, 2, 2));
		System.out.println(solution2(0, 2, 2));

		System.out.println(solution(11, 345, 17));
		System.out.println(solution2(11, 345, 17));

		System.out.println(solution(10, 10, 7));
		System.out.println(solution2(10, 10, 7));

		System.out.println(solution(1, 1, 11));
		System.out.println(solution2(1, 1, 11));
	}
}
