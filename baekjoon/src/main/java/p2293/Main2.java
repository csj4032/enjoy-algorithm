package p2293;

import java.util.Scanner;

public class Main2 {

	static int n;
	static int m;
	static int[] l;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		l = new int[n];

		for (int i = 0; i < n; i++) {
			l[i] = sc.nextInt();
		}

		System.out.println(recursive(m, 0));
	}

	private static int recursive(int m, int i) {
		if (m == 0) return 1;
		if (i >= n || m < 0) return 0;
		return recursive(m - l[i], i) + recursive(m, i + 1);
	}
}
