package p2751;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[] m = new boolean[2_000_001];
		for (int i = 0; i < n; i++) {
			m[sc.nextInt() + 1_000_000] = true;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 2_000_001; i++) {
			if (m[i]) {
				sb.append((i - 1000000) + "\n");
			}
		}

		System.out.print(sb.toString());
	}
}