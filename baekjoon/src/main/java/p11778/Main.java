package p11778;

import java.util.Scanner;

/**
 * 제목 : 피보나치 수와 최대공약수
 * 단계 : 수학
 * 힌트 : 행렬 곱셈
 */
public class Main {

	static int m = 1000000007;
	static int p = 2000000016;
	static int[] fibonacci;

	static {
		fibonacci = new int[p];
		fibonacci[0] = 0;
		fibonacci[1] = 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long nn = sc.nextLong();
		for (int i = 2; i < p; i++) {
			fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]);
			fibonacci[i] %= m;
		}
		System.out.println(gcd((fibonacci[(int) n % p]), fibonacci[(int) nn % p]));
	}

	private static int gcd(int a, int b) {
		if (b % a == 0) return a;
		return gcd(b % a, a);
	}
}
