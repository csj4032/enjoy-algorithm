package p11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static List<List<Integer>> graph = new ArrayList();
	private static int[] parent;
	private static boolean[] visitor;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		var n = Integer.parseInt(br.readLine());
		parent = new int[n];
		visitor = new boolean[n];
		visitor[0] = true;

		for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

		for (int i = 1; i <= n - 1; i++) {
			var c = br.readLine().split(" ");
			var a = Integer.parseInt(c[0]) - 1;
			var b = Integer.parseInt(c[1]) - 1;
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		dfs(0);
		for (int i = 1; i < n; i++) System.out.println(parent[i]);
	}

	private static void dfs(int idx) {
		for (int i = 0; i < graph.get(idx).size(); i++) {
			var next = graph.get(idx).get(i);
			if (!visitor[next]) {
				parent[next] = idx + 1;
				visitor[next] = true;
				dfs(next);
			}
		}
	}
}