package p10986;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 제목 : 나머지 합
 * 팁 : A1 ~ A5 합은 S5 - S0
 * (S5 - S0) % M = 0 이면 (S5 % M) == (S0 % M)
 * 조합론 kC2
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		long k = 0;
		long[] c = new long[1000];

		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			k += a;
			c[(int) (k % m)]++;
		}

		System.out.println(Arrays.toString(c));

		long t = c[0];
		for (int i = 0; i < m; i++) {
			t += (c[i] * (c[i] - 1)) / 2;
		}

		System.out.println(t);
	}
}