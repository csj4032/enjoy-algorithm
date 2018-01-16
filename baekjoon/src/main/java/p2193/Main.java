package p2193;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] m = new long[91];

		m[0] = 0;
		m[1] = 1;
		m[2] = 1;

		for (int i = 3; i <= n; i++) {
			m[i] = m[i - 2] + m[i - 1];
		}

		System.out.println(m[n]);
	}
}