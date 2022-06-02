package p11726;

import java.util.Scanner;

/**
 * 제목 : 2×n 타일링
 * 링크 : https://www.acmicpc.net/problem/11726
 * 분류 : 동적프로그래밍
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] m = new int[n + 1];

		m[0] = 1;
		m[1] = 1;

		for (int i = 2; i <= n; i++) {
			m[i] = (m[i - 2] + m[i - 1]) % 10007;
		}

		System.out.println(m[n]);
	}
}