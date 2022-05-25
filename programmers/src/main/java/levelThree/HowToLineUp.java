package levelThree;

import java.util.ArrayList;
import java.util.List;

public class HowToLineUp {

	public int[] solution(int n, long k) {
		int[] answer = new int[n];
		long[] factorial = new long[n + 1];
		factorial[0] = 1;
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
			factorial[i] = factorial(i);
		}
		k = k - 1;
		int i = 0;
		while (true) {
			long f = factorial[n - 1];
			int kk = (int) (k / f);
			long kkk = k % f;
			answer[i] = list.remove(kk);
			k = kkk;
			n = n - 1;
			i++;
			if (n == 0) break;
		}
		return answer;
	}

	public static long factorial(int number) {
		long result = 1;
		for (int factor = number; factor >= 2; factor--) {
			result *= factor;
		}
		return result;
	}
}
