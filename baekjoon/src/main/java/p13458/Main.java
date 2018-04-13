package p13458;

import java.util.Scanner;

/**
 * 제목 : 시험 감독
 * 풀이 : 감독관의 숫자가 생각보다 클 수 있음
 */
public class Main {

	private static Scanner sc;
	private static int[] m;
	private static int n;
	private static int a;
	private static int b;
	private static long t;

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		n = sc.nextInt();
		m = new int[1000001];

		for (int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
		}

		a = sc.nextInt();
		b = sc.nextInt();

		for (int i = 0; i < n; i++) {
			long k = m[i];
			long l = k - a;
			t += 1;
			if (l > 0) {
				while (l > 0) {
					l -= b;
					t++;
				}
			}
		}
		System.out.println(t);
	}
}