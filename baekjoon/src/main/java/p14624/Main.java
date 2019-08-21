package p14624;

import java.util.Scanner;

/**
 * 제목 : 전북대학교
 * URL : https://www.acmicpc.net/problem/14624
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		if ((n & 1) == 0) {
			System.out.println("I LOVE CBNU");
		} else {
			star(n);
		}
	}

	private static void star(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("*");
		}
		System.out.println();
		int m = (n + 1) / 2;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == m - j - 1 || j == i + m - 1) {
					System.out.print("*");
				} else {
					if (m + i > j) System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}