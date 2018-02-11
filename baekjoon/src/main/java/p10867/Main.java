package p10867;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] m = new int[2001];
		for (int i = 0; i < n; i++) {
			int t = sc.nextInt();
			m[t + 1000] = 1;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 2001; i++) {
			if (m[i] == 1) {
				sb.append(i - 1000).append(" ");
			}
		}

		System.out.println(sb.toString().trim());
	}
}