package p10811;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 제목 : 바구니 뒤집기
 * 링크 : https://www.acmicpc.net/problem/10811
 */
public class Main {

	static int n;
	static int m;
	static int[] nn;
	static StringBuilder sb;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		nn = new int[n];
		sb = new StringBuilder();
		for (int i = 0; i < n; i++) nn[i] = i + 1;
		for (int i = 0; i < m; i++) reverse(sc.nextInt(), sc.nextInt());
		for (int i = 0; i < n; i++) sb.append(nn[i] + " ");
		System.out.println(sb.toString());
	}

	private static void reverse(int s, int e) {
		int[] d = Arrays.copyOfRange(nn, s - 1, e);
		for (int i = 0; i < d.length; i++) nn[s + i - 1] = d[d.length - i - 1];
	}
}
