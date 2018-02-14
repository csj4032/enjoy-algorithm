package p10942;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] m = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			m[i] = sc.nextInt();
		}

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			System.out.println(palindrome(s, e, m));
		}
	}

	private static int palindrome(int s, int e, int[] m) {
		while (s < e) {
			if (m[s++] != m[e--]) return 0;
		}
		return 1;
	}
}