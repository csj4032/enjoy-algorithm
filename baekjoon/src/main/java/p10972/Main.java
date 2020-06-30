package p10972;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 제목 : 다음 순열
 * 링크 : https://www.acmicpc.net/problem/10972
 * 분류 : 순
 */
public class Main {

	private static int[] m;
	private static int[] x;
	private static int[] a;
	private static int n;
	private static boolean[] v;
	private static boolean c = false;
	private static boolean e = false;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		m = new int[n];
		x = new int[n];
		a = new int[n];
		v = new boolean[n];
		for (int i = 0; i < n; i++) x[i] = sc.nextInt();
		recursive(0, 0);
	}

	private static void recursive(int d, int k) {
		if (d == n) {
			System.out.println(Arrays.toString(x));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (v[i]) continue;
			v[i] = true;
			x[i] = d + 1;
			recursive(d + 1, k + 1);
			v[i] = false;
		}
	}
}
