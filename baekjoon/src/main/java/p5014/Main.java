package p5014;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 제목 : 스타트링크
 * 링크 : https://www.acmicpc.net/problem/5014
 * 분류 : BFS, 그래프 이론, 그래프 탐색, 너비 우선 탐색
 */
public class Main {

	static int f;
	static int s;
	static int g;
	static int u;
	static int d;
	static int k = Integer.MAX_VALUE;
	static boolean[] v;
	static LinkedList<Tuple> q = new LinkedList<>();

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		f = sc.nextInt();
		s = sc.nextInt();
		g = sc.nextInt();
		u = sc.nextInt();
		d = sc.nextInt();
		v = new boolean[f + 1];
		q.add(new Tuple(s, 0));
		bfs();
		if (k == Integer.MAX_VALUE) {
			System.out.println("use the stairs");
		} else {
			System.out.println(k);
		}
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			var t = q.getFirst();
			q.pop();
			if (!v[t.c]) {
				v[t.c] = true;
				if (t.c == g) k = Math.min(k, t.d);
				if (t.c - d > 0 && !v[t.c - d]) q.add(new Tuple(t.c - d, t.d + 1));
				if (t.c + u <= f && !v[t.c + u]) q.add(new Tuple(t.c + u, t.d + 1));
			}
		}
	}
}

class Tuple {
	int c;
	int d;

	public Tuple(int c, int d) {
		this.c = c;
		this.d = d;
	}

	@Override
	public String toString() {
		return "Tuple{" +
				"c=" + c +
				", d=" + d +
				'}';
	}
}
