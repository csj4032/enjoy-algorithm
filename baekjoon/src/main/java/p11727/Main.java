package p11727;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] m = new int[1001];

		m[1] = 1;
		m[2] = 3;

		for (int i = 3; i <= n; i++) {
			m[i] = (m[i - 1] + m[i - 2] * 2) % 10007;
		}
		System.out.println(m[n]);
	}
}