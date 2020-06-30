package p7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 제목 : 토마토
 * 링크 : https://www.acmicpc.net/problem/7576
 * 분류 : BFS
 */
public class Main {

	static int[][] graph;
	static Deque<Point> deque = new LinkedList<>();
	static int direction[][] = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
	static int n;
	static int m;
	static int q = -1;
	static boolean f = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nn = br.readLine().split(" ");
		n = Integer.parseInt(nn[0]);
		m = Integer.parseInt(nn[1]);
		graph = new int[m][n];
		for (int i = 0; i < m; i++) {
			String[] mm = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(mm[j]);
				if (graph[i][j] == 1) {
					deque.push(new Point(i, j, 0));
				}
			}
		}
		bfs();
		System.out.println(q);
	}

	private static void bfs() {
		while (!deque.isEmpty()) {
			Point p = deque.peek();
			deque.pop();
			for (int k = 0; k < 4; k++) {
				int[] d = direction[k];
				int y = p.y + d[0];
				int x = p.x + d[1];
				if (y >= 0 && y < m && x >= 0 && x < n && graph[y][x] == 0) {
					Point pp = new Point(y, x, p.d + 1);
					deque.addLast(pp);
					graph[y][x] = 1;
				}
			}
			q = p.d;
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (graph[i][j] == 0) {
					f = true;
					break;
				}
			}
		}
		if (f) q = -1;
	}
}

class Point {
	int y;
	int x;
	int d;

	public Point(int y, int x, int d) {
		this.y = y;
		this.x = x;
		this.d = d;
	}
}