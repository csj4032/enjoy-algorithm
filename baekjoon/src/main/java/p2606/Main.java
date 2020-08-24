package p2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 제목 : 바이러스
 * 링크 : https://www.acmicpc.net/problem/2606
 * 분류 : 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
 */
public class Main {

	private static List<List<Integer>> graph = new ArrayList();
	private static boolean[] virus;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		var n = Integer.parseInt(br.readLine());
		var m = Integer.parseInt(br.readLine());
		var k = 0;
		virus = new boolean[n];
		virus[0] = true;

		for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
		for (int i = 0; i < m; i++) {
			var c = br.readLine().split(" ");
			var a = Integer.parseInt(c[0]) - 1;
			var b = Integer.parseInt(c[1]) - 1;
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		dfs(0);

		for (int i = 1; i < n; i++) if (virus[i]) k++;

		System.out.println(k);
	}

	private static void dfs(int idx) {
		for (int i = 0; i < graph.get(idx).size(); i++) {
			var next = graph.get(idx).get(i);
			if (!virus[next]) {
				virus[next] = true;
				dfs(next);
			}
		}
	}
}
