package p9082;

import java.util.Scanner;

/**
 * 제목 : 지뢰찾기
 * 링크 : https://www.acmicpc.net/problem/9082
 * 분류 : 조합, 이진 (O,X)
 */
public class Main2 {
	static int k = 0;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			var n = sc.nextInt();
			var m = new int[n + 2];
			var mm = ("0" + sc.next() + "0").split("");
			var s = ("#" + sc.next() + "#").split("");
			var ss = 0;
			for (int j = 1; j <= n; j++) {
				m[j] = Integer.parseInt(mm[j]);
				ss += m[j];
			}
			dfs(1, n, m, s);
			System.out.println(k);
		}
	}

	private static void dfs(int d, int n, int[] m, String[] s) {
		if (isAble(s, m)) {
			var kk = 0;
			for (int i = 0; i <= n; i++) if (s[i + 1].equals("*")) kk++;
			k = Math.max(k, kk);
		}
		if (d == n) return;
		for (int i = d; i < n; i++) {
			if (!s[i].equals("*")) {
				s[i] = "*";
				dfs(d + 1, n, m, s);
				s[i] = "#";
			}
		}
	}

	private static boolean isAble(String[] s, int[] m) {
		for (int i = 1; i < m.length - 1; i++) {
			var kk = 0;
			for (int j = i - 1; j <= i + 1; j++) {
				if (s[j].equals("*")) kk++;
			}
			if (kk != m[i]) return false;
		}
		return true;
	}
}