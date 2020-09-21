package p16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 제목 : 아기 상어
 * 링크 : https://www.acmicpc.net/problem/16236
 * 분류 : 구현, 그래프 이론, 그래프 탐색, 너비 우선 탐색, 시뮬레이션
 * 기출 : 삼성 SW 역량 테스트 기출 문제
 */
public class Main {

	static int n;
	static int k;
	static int[][] m;
	static int[] dy = new int[]{1, -1, 0, 0};
	static int[] dx = new int[]{0, 0, -1, 1};

	static boolean[][] visitor;
	static Tuple start;
	static PriorityQueue<Tuple> list;
	static PriorityQueue<Tuple> paths = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		var br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int j = 0;
			while (st.hasMoreTokens()) {
				m[i][j] = Integer.parseInt(st.nextToken());
				if (m[i][j] == 9) {
					start = new Tuple(i, j, 2, 2, 0);
				}
				j++;
			}
		}
		paths.add(start);
		while (true) {
			var tt = bfs();
			if (tt == null) break;
			k += tt.d;
			start.w--;
			if (start.w == 0) {
				start.z = start.z + 1;
				start.w = start.z;
			}
			m[start.r][start.c] = 0;
			m[tt.r][tt.c] = 100000;
			start.r = tt.r;
			start.c = tt.c;
			paths.add(start);
		}

		System.out.println(k);
	}

	private static Tuple bfs() {
		list = new PriorityQueue<>();
		visitor = new boolean[n][n];
		while (!paths.isEmpty()) {
			var path = paths.peek();
			paths.poll();
			if (path.z > 0 && start.z > path.z) list.add(path);

			for (int i = 0; i < 4; i++) {
				var rr = path.r + dy[i];
				var cc = path.c + dx[i];
				if (rr >= 0 && rr < n && cc >= 0 && cc < n && !visitor[rr][cc] && m[rr][cc] <= start.z) {
					var zz = m[rr][cc];
					visitor[rr][cc] = true;
					paths.add(new Tuple(rr, cc, zz, 0, path.d + 1));
				}
			}
		}
		return list.poll();
	}
}

class Tuple implements Comparable<Tuple> {
	Integer r;
	Integer c;
	int z;
	int w;
	Integer d;

	public Tuple(Integer r, Integer c, int z, int w, Integer d) {
		this.r = r;
		this.c = c;
		this.z = z;
		this.w = w;
		this.d = d;
	}

	@Override
	public String toString() {
		return "Tuple{" +
				"r=" + r +
				", c=" + c +
				", z=" + z +
				", w=" + w +
				", d=" + d +
				'}';
	}

	@Override
	public int compareTo(Tuple o) {
		var c = 0;
		c = this.d.compareTo(o.d);
		if (c == 0) c = this.r.compareTo(o.r);
		if (c == 0) c = this.c.compareTo(o.c);
		return c;
	}
}
/*
10
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 9
* */