package levelTwo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class TargetNumber {

	private static int COUNT = 0;

	public int dfs(int[] numbers, int target) {
		int len = numbers.length;
		exhaustiveSearch(len, 0, 2, new int[len], numbers, target);
		return COUNT;
	}

	private void exhaustiveSearch(int len, int step, int cases, int[] set, int[] numbers, int target) {
		if (len == step) {
			int sum = 0;
			for (int i = 0; i < len; i++) {
				if (set[i] > 0) {
					sum = sum + numbers[i];
				} else {
					sum = sum + (numbers[i] * -1);
				}
			}
			if (sum == target) COUNT++;
			return;
		}
		for (int i = 0; i < cases; i++) {
			set[step] = i;
			exhaustiveSearch(len, step + 1, cases, set, numbers, target);
		}
	}




	public int dfs2(int[] numbers, int step, int sum, int target) {
		if (numbers.length == step) {
			if (sum == target) return 1;
			return 0;
		}
		return dfs2(numbers, step + 1, sum + numbers[step], target) + dfs2(numbers, step + 1, sum - numbers[step], target);
	}

	public int bfs(int[] numbers, int target) {
		int answer = 0;
		Queue<Integer> bfs = new LinkedList<>();
		int cnt = 0;
		bfs.add(numbers[0]);
		bfs.add(-numbers[0]);
		while (!bfs.isEmpty()) {
			if (bfs.size() == Math.pow(2, numbers.length)) {
				Iterator<Integer> it = bfs.iterator();
				while (it.hasNext()) {
					int data = it.next();
					if (data == target) answer++;
				}
				break;
			}
			if (bfs.size() == Math.pow(2, cnt + 1)) cnt++;
			int temp = bfs.poll();
			bfs.add(temp + numbers[cnt]);
			bfs.add(temp - numbers[cnt]);
		}
		return answer;
	}
}





