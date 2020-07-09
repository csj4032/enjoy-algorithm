package p11724;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] v;
	static Integer[] rr;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var m = sc.nextInt();
		v = new boolean[n];
		rr = new Integer[n];
		for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
		for (int i = 0; i < m; i++) {
			var a = sc.nextInt();
			var b = sc.nextInt();
			graph.get(a - 1).add(b);
			graph.get(b - 1).add(a);
		}
		for (int i = 0; i < n; i++) dfs(i + 1, i + 1);
		System.out.println(Stream.of(rr).collect(Collectors.groupingBy(e -> e.intValue())).keySet().size());
	}

	private static void dfs(int i, int r) {
		if (v[i - 1]) return;
		v[i - 1] = true;
		var vec = graph.get(i - 1);
		for (int j = 0; j < vec.size(); j++) {
			var t = vec.get(j);
			if (!v[t - 1]) dfs(t, r);
		}
		rr[i - 1] = r;
	}
}