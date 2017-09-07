package p2293;

import java.util.Scanner;

public class Main {

	static int[] m;
	static int n;
	static int k;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		m = new int[n];
		for (int i = 0; i < n; i++) m[i] = sc.nextInt();
		System.out.println(recursive(k, 0));
	}

	private static int recursive(int k, int s) {
		if (k < 0 || n <= s) {
			System.out.println(k + " : " +s);
			return 0;
		} else if (k == 0) {
			System.out.println(k + " " +s);
			return 1;
		}
		return recursive(k - m[s], s) + recursive(k, s + 1);
	}
}