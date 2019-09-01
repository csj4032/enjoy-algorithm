package p9461;

import java.util.Scanner;

/**
 * 제목 : 파도반 수열
 * 링크 : https://www.acmicpc.net/problem/9461
 * 분류 : 다이나믹 프로그래밍
 */
public class Main {

	static long[] p = new long[101];
	static StringBuilder sb = new StringBuilder();

	static {
		p[1] = 1;
		p[2] = 1;
		p[3] = 1;
		for (int i = 4; i < 101; i++) {
			p[i] = p[i - 3] + p[i - 2];
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			sb.append(p[n]+"\n");
		}
		System.out.println(sb.toString());
	}
}
