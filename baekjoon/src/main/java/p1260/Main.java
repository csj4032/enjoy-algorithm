package p1260;

import java.util.*;

public class Main {

	private static StringBuilder sf1;
	private static StringBuilder sf2;
	private static int graph[][];
	private static int visit1[];
	private static int visit2[];
	private static int m;
	private static int n;
	private static int v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();

		sf1 = new StringBuilder();
		sf2 = new StringBuilder();
		graph = new int[n + 1][n + 1];
		visit1 = new int[n + 1];
		visit2 = new int[n + 1];

		for (int i = 1; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x][y] = graph[y][x] = 1;
		}

		dfs(v);
		System.out.println(sf1.toString().trim());


		bfs(v);
		System.out.print(sf2.toString().trim());
	}

	private static void dfs(int v) {
		visit1[v] = 1;
		sf1.append(v + " ");
		for (int i = 1; i <= n; i++) {
			if (visit1[i] != 1 && graph[v][i] == 1) {
				dfs(i);
			}
		}
	}

	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList();
		queue.add(v);
		visit2[v] = 1;
		//sf2.append(v + " ");
		while (!queue.isEmpty()) {
			int x = queue.peek();
			queue.poll();
			sf2.append(x + " ");
			for (int i = 1; i <= n; i++) {
				if (graph[x][i] == 1 && visit2[i] != 1) {
					queue.add(i);
					visit2[i] = 1;
				}
			}
		}
	}
}