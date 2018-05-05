package p10539;

import java.util.Scanner;

public class Main {

	static int n;
	static int t;
	static int k;
	static StringBuilder sb;
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		n = sc.nextInt();
		sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			k = sc.nextInt();
			int q = k * i - t;
			t += q;
			sb.append(q+ " ");
		}
		System.out.println(sb.toString().trim());
	}
}
