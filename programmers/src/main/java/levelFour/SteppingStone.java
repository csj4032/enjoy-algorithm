package levelFour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SteppingStone {

	static int answer = 0;

	public int solution(int distance, int[] rocks, int n) {
		int length = rocks.length;
		Arrays.sort(rocks);
		combination(0, length, n, rocks, distance, new boolean[length]);
		return answer;
	}

	private void combination(int from, int to, int depth, int[] rocks, int distance, boolean[] visited) {
		if (depth == 0) {
			AtomicInteger min = new AtomicInteger(Integer.MAX_VALUE);
			List<Integer> remain = new ArrayList<>();
			remain.add(0);
			for (int i = 0; i < to; i++) {
				if (!visited[i]) {
					remain.add(rocks[i]);
				}
			}
			remain.add(distance);
			remain.stream().reduce((a, b) -> {
				if (min.get() > Math.abs(a - b)) {
					min.set(Math.abs(a - b));
				}
				return b;
			});
			if (min.get() > answer) {
				answer = min.get();
			}
			return;
		}
		for (int i = from; i < to; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			combination(i, to, depth - 1, rocks, distance, visited);
			visited[i] = false;
		}
	}
}