package p1766;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 제목 : 문제집
 * 링크 : https://www.acmicpc.net/problem/1766
 * 분류 : 힙, 위상 정렬(DAG: Directed Acyclic Graph)
 */
public class Main {

	static List<List<Integer>> graph = new ArrayList<>();
	static int[] inDegree;
	static List<Integer> result = new LinkedList<>();
	static PriorityQueue<Integer> queue = new PriorityQueue<>();

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var m = sc.nextInt();

		inDegree = new int[n + 1];

		for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
		for (int i = 0; i < m; i++) {
			var k = sc.nextInt();
			var l = sc.nextInt();
			graph.get(k).add(l);
			inDegree[l]++;
		}

		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			var t = queue.peek();
			queue.poll();
			result.add(t);
			List<Integer> e = graph.get(t);
			for (int i = 0; i < e.size(); i++) {
				var q = e.get(i);
				--inDegree[q];
				if (inDegree[q] == 0) {
					queue.offer(q);
				}
			}
		}

		System.out.println(result.stream().map(e -> e.toString()).collect(Collectors.joining(" ")));
	}
}
