package p2644;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static List<List<Integer>> graph = new ArrayList();
	private static boolean[] visitor;
	private static int x;
	private static int y;
	private static int k = -1;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		var m = sc.nextInt();
		visitor = new boolean[n];

		for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

		for (int i = 0; i < m; i++) {
			var a = sc.nextInt() - 1;
			var b = sc.nextInt() - 1;
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		visitor[x - 1] = true;
		dfs(x - 1, 0);
		System.out.println(k);
	}

	private static void dfs(int idx, int node) {
		for (int i = 0; i < graph.get(idx).size(); i++) {
			var next = graph.get(idx).get(i);
			if (!visitor[next]) {
				visitor[next] = true;
				dfs(next, node + 1);
				if (next == (y - 1)) {
					k = node + 1;
				}
			}
		}
	}
}