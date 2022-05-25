package levelThree;

import java.util.Arrays;
import java.util.LinkedList;

public class HowToLineUp {

	static int mm = 0;
	static long kk = 0;
	static long tt = 0;
	static long qq = 1;
	static int[] numbers;
	static int[] permutations;
	static int[] answer;
	static boolean[] visited;

	public int[] solution(int n, long k) {
		numbers = new int[n];
		permutations = new int[n];
		answer = new int[n];
		visited = new boolean[n];
		kk = k;
		qq = factorial(n - 1);
		mm = (int) (k / qq);
		tt = (int) (k / qq) * qq;

		System.out.println(qq + " " + mm + " " + tt);

		LinkedList<Integer> numberList = new LinkedList<>();
		for (int i = 1; i <= n; i++) numberList.add(i);
		numberList.remove(mm);
		numbers = numberList.stream().mapToInt(e -> e.intValue()).toArray();
		permutation(0, n-1);
		System.out.println(Arrays.toString(answer));
		return answer;
	}

	public static long factorial(int number) {
		long result = 1;
		for (int factor = number; factor >= 2; factor--) {
			result *= factor;
		}
		return result;
	}

	private static void permutation(int idx, int n) {
		if (idx == n) {
			tt++;
			if (kk == tt) answer = permutations;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i]) continue;
			permutations[idx] = numbers[i];
			visited[i] = true;
			permutation(idx + 1, n);
			visited[i] = false;
		}
	}
}
