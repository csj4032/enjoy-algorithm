package p2903;

import java.util.Scanner;

public class Main {

	static long[] m = new long[16];

	static {
		m[0] = 2;
		for (int i = 1; i < 16; i++) {
			m[i] = m[i - 1] * 2 - 1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(m[n] * m[n]);
	}
}
