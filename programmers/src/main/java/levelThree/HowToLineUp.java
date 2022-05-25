package levelThree;

import java.util.Arrays;
import java.util.LinkedList;

public class HowToLineUp {


	public int[] solution(int n, long k) {
		int[] answer = new int[n];
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		int i = 0;
		while (true) {
			long f = factorial(n - 1);
			int kk = (int) (k / f);
			int kkk = (int) (k % f);
			if (n == 0) {
				//answer[n] = list.get(0);
				//answer[n - 1] = list.get(1);
				break;
			}
			k = kkk;
			n = n - 1;
			answer[i] = list.get(kk);
			list.remove(kk);
			i++;
			System.out.println(kk + " " + kkk);
			System.out.println(Arrays.toString(answer));
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
