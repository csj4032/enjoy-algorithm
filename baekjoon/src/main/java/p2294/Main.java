package p2294;

import java.util.Scanner;

public class Main {

	static int n;
	static int m;
	static int p = 1000000000;
	static int k[];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		k = new int[n];

		for (int i = 0; i < n; i++) {
			k[i] = in.nextInt();
		}

		recursive(0, m, 0);
		System.out.println(p);
	}

	private static int recursive(int i, int m, int l) {
		if (m < 0 || i >= n) {
			return -1;
		}
		if (m == 0) {
			if (p > l) p = l;
			return l;
		}

		return recursive(i, m - k[i], l + 1) + recursive(i + 1, m, l);
	}
}
