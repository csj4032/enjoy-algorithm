package p2579;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] m = new int[n];
		int[] s = new int[n];

		for (int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
		}

		s[0] = m[0];
		s[1] = Math.max(m[0] + m[1], m[1]);
		s[2] = Math.max(m[0] + m[2], m[1] + m[2]);

		for (int i = 3; i < n; i++) {
			s[i] = Math.max(s[i - 2] + m[i], m[i - 1] + m[i]+s[i - 3] );
		}
		System.out.println(s[n-1]);
	}
}