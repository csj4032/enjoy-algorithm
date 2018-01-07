package p1912;

import java.util.Scanner;

public class Main2 {

	static int max = 0;
	static int n = 0;
	static int[] m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = new int[n];
		for (int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
		}
		recursive(n - 1, 0);
		System.out.println(max);
	}

	private static int recursive(int i, int s) {
		if (i < 0) return s;
		s += m[i];
		System.out.println(s);
		return recursive(i - 1, s) + recursive(i - 2, s);
	}
}