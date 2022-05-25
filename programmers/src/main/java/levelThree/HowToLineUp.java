package levelThree;

import java.util.Arrays;
import java.util.LinkedList;

public class HowToLineUp {


	public int[] solution(int n, long k) {
		LinkedList list = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		long f = factorial(n - 1);


		return null;
	}

	public static long factorial(int number) {
		long result = 1;
		for (int factor = number; factor >= 2; factor--) {
			result *= factor;
		}
		return result;
	}
}
