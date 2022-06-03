package levelTwo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MenuRenewal {

	public String[] solution(String[] orders, int[] course) {
		String[] answer = {};
		Set<String> alphabet = new HashSet<>();
		for (int i = 0; i < orders.length; i++) {
			String[] order = orders[i].split("");
			for (int j = 0; j < order.length; j++) {
				alphabet.add(order[j]);
			}
		}
		String[] unique = alphabet.toArray(new String[]{});
		System.out.println(Arrays.toString(unique));

		for (int i = 0; i < course.length; i++) {
			int size = course[i];
			permutation(unique.length, size, 0, unique);
			System.out.println(" ");
		}
		return answer;
	}


	private static void permutation(int n, int m, int depth, String[] unique) {
		if (depth == m) {
			System.out.println(Arrays.toString(unique));
			return;
		}
		for (int i = depth; i < n; i++) {
			swap(i, depth, unique);
			permutation(n, m, depth + 1, unique);
			swap(i, depth, unique);
		}
	}

	private static void swap(int p, int q, String[] unique) {
		String t = unique[p];
		unique[p] = unique[q];
		unique[q] = t;
	}
}
