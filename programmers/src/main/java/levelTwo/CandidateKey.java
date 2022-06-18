package levelTwo;

import java.util.*;

public class CandidateKey {

	static int answer = 0;
	static List<List<Integer>> blocks;

	public int solution(String[][] relation) {
		answer = 0;
		blocks = new ArrayList<>();
		int cols = relation[0].length;
		int[] combinationArray = new int[cols];
		Arrays.fill(combinationArray, -1);
		for (int i = 1; i <= cols; i++) {
			combination(0, cols, i, new boolean[cols], relation);
		}
		return answer;
	}

	private static void combination(int from, int to, int depth, boolean[] visited, String[][] relation) {
		if (depth == 0) {
			List<Integer> visits = new ArrayList<>();
			List<String> values = new ArrayList<>();
			Set<String> unique = new HashSet<>();
			boolean flag = false;
			for (int i = 0; i < to; i++) if (visited[i]) visits.add(i);
			for (int i = 0; i < blocks.size(); i++) if (visits.containsAll(blocks.get(i))) flag = true;
			if (!flag) {
				for (int i = 0; i < relation.length; i++) {
					String value = "";
					for (int j = 0; j < to; j++) {
						if (visited[j]) {
							value = value + "|" + relation[i][j];
						}
					}
					values.add(value);
				}
				unique.addAll(values);
				if (unique.size() == values.size()) {
					System.out.println(values);
					List<Integer> keys = new ArrayList<>();
					for (int i = 0; i < to; i++) {
						if (visited[i]) keys.add(i);
					}
					blocks.add(keys);
					answer++;
				}
			}
		}

		for (int i = from; i < to; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			combination(i, to, depth - 1, visited, relation);
			visited[i] = false;
		}
	}
}
