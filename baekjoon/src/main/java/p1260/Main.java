package p1260;

import java.util.*;

/**
 * 제목 : DFS 와 BFS
 * 링크 : https://www.acmicpc.net/problem/1260
 * 분류 : 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
 */
public class Main {

	private static StringBuilder sf1;
	private static StringBuilder sf2;
	private static boolean graph[][];
	private static boolean visit[];
	private static boolean flag;
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
		graph = new boolean[1001][1001];
		visit = new boolean[1001];

		for (int i = 1; i <= m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x][y] = graph[y][x] = true;
		}

		dfss(v);
		visit = new boolean[1001];
		bfs(v);
		System.out.println(sf1.toString().trim());
		System.out.print(sf2.toString().trim());
	}

	private static void dfsr(int v) {
		visit[v] = true;
		sf1.append(v + " ");
		for (int i = 1; i <= n; i++) {
			if (graph[v][i] == true && visit[i] == false) {
				dfsr(i);
			}
		}
	}

	private static void dfss(int v) {
		Stack<Integer> stack = new Stack<>();
		stack.push(v);
		visit[v] = true;
		sf1.append(v + " ");
		while (!stack.isEmpty()) {
			flag = false;
			int x = stack.peek();
			for (int i = 1; i <= n; i++) {
				if (graph[x][i] == true && visit[i] == false) {
					stack.push(i);
					visit[i] = true;
					flag = true;
					sf1.append(i + " ");
					break;
				}
			}
			if (!flag) stack.pop();
		}
	}

	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList();
		queue.offer(v);
		visit[v] = true;
		while (!queue.isEmpty()) {
			int x = queue.poll();
			sf2.append(x + " ");
			for (int i = 1; i <= n; i++) {
				if (graph[x][i] == true && visit[i] == false) {
					queue.offer(i);
					visit[i] = true;
				}
			}
		}
	}
}