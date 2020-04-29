package p16637;

import java.util.Scanner;

public class Main {

	private static int n;
	private static String l;
	private static int on;
	private static int[] m = new int[20];
	private static char[] o = new char[20];
	private static int max;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		l = sc.next();
		int j = 0, k = 0;
		for (int i = 0; i < l.length(); i++) {
			if ((i % 2) == 0) {
				m[j++] = l.charAt(i) - '0';
			} else {
				o[k++] = l.charAt(i);
			}
		}
		on = n / 2;
		dfs(0, m[0]);
		System.out.println(max);
	}

	private static void dfs(int i, int r) {
		if (i >= on) {
			max = Math.max(max, r);
			return;
		}
		int cr = cal(r, m[i + 1], o[i]);
		dfs(i + 1, cr);

		if (i + 1 < on) {
			int ar = cal(m[i + 1], m[i + 2], o[i + 1]);
			cr = cal(r, ar, o[i]);
			dfs(i + 2, cr);
		}
	}

	private static int cal(int n1, int n2, char c) {
		if (c == '+') return n1 + n2;
		if (c == '-') return n1 - n2;
		return n1 * n2;
	}
}
