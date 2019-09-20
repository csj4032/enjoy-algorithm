package p11944;

import java.util.Scanner;

/**
 * 제목 : NN
 * 링크 : https://www.acmicpc.net/problem/11944
 */
public class Main {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = String.valueOf(n).length() * n;
		for (int i = 0; i < n; i++) sb.append(n);
		if (l >= m) {
			System.out.println(sb.substring(0, m));
		} else {
			System.out.println(sb.toString());
		}
	}
}