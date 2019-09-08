package p9506;

import java.util.Scanner;

/**
 * 제목 : 약수들의 합
 * 링크 : https://www.acmicpc.net/problem/9506
 * 6, 28, 496, 8128
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == -1) break;
			denominator(n);
		}
	}

	private static void denominator(int n) {
		int sum = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0) {
				if (i == n / 2) {
					sb.append(i);
				} else {
					sb.append(i + " + ");
				}
				sum += i;
			}
		}
		if (n == sum) {
			System.out.println(n + " = " + sb);
		} else {
			System.out.println(n + " is NOT perfect.");
		}
	}
}