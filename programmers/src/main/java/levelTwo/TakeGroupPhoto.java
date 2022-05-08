package levelTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TakeGroupPhoto {

	private static final String[] members = {"A", "C", "F", "J", "M", "N", "R", "T"};
	private static List<Condition> conditions;
	private static Integer answer;

	public int solution(int n, String[] data) {
		conditions = new ArrayList<>();
		answer = 0;
		for (int i = 0; i < data.length; i++) {
			String[] ss = data[i].split("");
			conditions.add(new Condition(ss[0], ss[2], ss[3], Integer.parseInt(ss[4])));
		}
		permutation(8, 8, 0, n);
		return answer;
	}

	private void permutation(int n, int m, int depth, int k) {
		if (depth == m) {
			if (check()) {
				answer++;
			}
			return;
		}
		for (int i = depth; i < n; i++) {
			swap(i, depth);
			permutation(n, m, depth + 1, k);
			swap(i, depth);
		}
	}

	private static void swap(int p, int q) {
		String t = members[p];
		members[p] = members[q];
		members[q] = t;
	}

	private boolean check() {
		for (Condition condition : conditions) {
			int from = Arrays.asList(members).indexOf(condition.from);
			int to = Arrays.asList(members).indexOf(condition.to);
			if (condition.operation.equals("=")) {
				if ((Math.abs(to - from) - 1) != condition.value) {
					return false;
				}
			} else if (condition.operation.equals("<")) {
				if ((Math.abs(to - from) - 1) >= condition.value) {
					return false;
				}
			} else {
				if ((Math.abs(to - from) - 1) <= condition.value) {
					return false;
				}
			}
		}
		return true;
	}
}

class Condition {
	String from;
	String to;
	String operation;
	int value;

	public Condition(String from, String to, String operation, int value) {
		this.from = from;
		this.to = to;
		this.operation = operation;
		this.value = value;
	}
}
