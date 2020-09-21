package p10819;

import java.util.Scanner;

/**
 * 제목 : 차이를 최대로
 * 링크 : https://www.acmicpc.net/problem/10819
 * 분류 : 브루트포스 알고리즘, 백트래킹
 */
public class Main {

	static int t;
	static int k;
	static int[] l;
	static int[] m;
	static boolean[] v;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		t = sc.nextInt();
		l = new int[t];
		m = new int[t];
		//v = new boolean[t];
		for (int i = 0; i < t; i++) l[i] = sc.nextInt();
		recursive(0);
		System.out.println(k);
	}

	private static void recursive(int d) {
		if (d == t) {
			var a = 0;
			for (int i = 0; i < t - 1; i++) {
				a += Math.abs(l[m[i]] - l[m[i + 1]]);
			}
			k = Math.max(a, k);
		}

		for (int i = 0; i < t; i++) {
			if (!v[i]) {
				v[i] = true;
				m[i] = d;
				recursive(d + 1);
				v[i] = false;
			}
		}
	}
}