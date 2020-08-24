package p2042;

import java.util.Scanner;

public class Main {

	private static long nn[];
	private static long tree[];

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var m = sc.nextInt();
		var k = sc.nextInt();
		m += k;
		nn = new long[n];
		tree = new long[n * n];
		for (int i = 0; i < n; i++) nn[i] = sc.nextInt();

		init(nn, tree, 1, 0, n - 1);

		while (m-- > 0) {
			var a = sc.nextInt();
			var b = sc.nextInt();
			if (a == 1) {
				var c = sc.nextLong();
				var diff = c - nn[b - 1];
				nn[b - 1] = c;
				update(tree, 1, 0, n - 1, b - 1, diff);
			} else if (a == 2) {
				var c = sc.nextInt();
				System.out.println(sum(tree, 1, 0, n - 1, b - 1, c - 1));
			}
		}
	}

	private static long init(long[] nn, long[] tree, int node, int start, int end) {
		if (start == end) {
			return tree[node] = nn[start];
		}
		return tree[node] = init(nn, tree, node * 2, start, (start + end) / 2) + init(nn, tree, node * 2 + 1, (start + end) / 2 + 1, end);
	}

	private static long sum(long[] tree, int node, int start, int end, int left, int right) {
		if (end < left || start > right) {
			return 0;
		}
		if (left <= start && end <= right) {
			return tree[node];
		}
		return sum(tree, node * 2, start, (start + end) / 2, left, right) + sum(tree, node * 2 + 1, (start + end) / 2 + 1, end, left, right);
	}

	private static void update(long[] tree, int node, int start, int end, int index, long diff) {
		if (index < start || index > end) return;
		tree[node] = tree[node] + diff;
		if (start != end) {
			update(tree, node * 2, start, (start + end) / 2, index, diff);
			update(tree, node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
		}
	}
}
