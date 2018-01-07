package p2293;

import java.util.Scanner;

public class Main {

	static int[] m;
	static int k;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		m = new int[n];
		for (int i = 0; i < n; i++) m[i] = sc.nextInt();
		System.out.println(recursive(k, 0));
	}

	private static int recursive(int q, int s) {
		if (q == 0) {
			return 1;
		} else if (q < 0 || n <= s) {
			return 0;
		}
		return recursive(q - m[s], s) + recursive(q, s + 1);
	}
}