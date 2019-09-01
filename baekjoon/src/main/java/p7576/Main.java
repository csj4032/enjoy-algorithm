package p7576;

import java.util.*;

public class Main {

	static int[][] graph;
	static boolean[][] visited;
	static Queue<Integer> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		graph = new int[n][m];
		visited = new boolean[n][m];
		queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				graph[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] == 1) {
					bfs(i, j);
				}
			}
		}
		System.out.println(Arrays.deepToString(graph));
	}

	private static void bfs(int i, int j) {
		if (visited[i][j]) return;
		visited[i][j] = true;
		queue.offer(1);
		while (!queue.isEmpty()) {

		}
	}
}
