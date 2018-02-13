package p2178;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	static Deque<int[]> s = new LinkedList<>();
	static int n;
	static int m;
	static int t[][];
	static int p[][];
	static boolean v[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		t = new int[n][m];
		p = new int[n][m];
		v = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String[] r = sc.next().split("");
			for (int j = 0; j < m; j++) {
				t[i][j] = Integer.valueOf(r[j]);
			}
		}

		s.add(new int[]{0, 0, 1});
		v[0][0] = true;

		recursive();

		System.out.println(p[n - 1][m - 1]);
	}

	private static void recursive() {

		if (s.isEmpty()) return;

		int[] pos = s.poll();
		int r = pos[0];
		int c = pos[1];
		int d = pos[2];
		p[r][c] = d;

		// 우
		if (m > c + 1 && t[r][c + 1] == 1 && !v[r][c + 1]) {
			s.addLast(new int[]{r, c + 1, d + 1});
			v[r][c + 1] = true;
		}

		// 하
		if (n > r + 1 && t[r + 1][c] == 1 && !v[r + 1][c]) {
			s.addLast(new int[]{r + 1, c, d + 1});
			v[r + 1][c] = true;
		}

		// 좌
		if (0 <= c - 1 && t[r][c - 1] == 1 && !v[r][c - 1]) {
			s.addLast(new int[]{r, c - 1, d + 1});
			v[r][c - 1] = true;
		}

		// 상
		if (0 <= r - 1 && t[r - 1][c] == 1 && !v[r - 1][c]) {
			s.addLast(new int[]{r - 1, c, d + 1});
			v[r - 1][c] = true;
		}

		recursive();
	}
}