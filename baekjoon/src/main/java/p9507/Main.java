package p9507;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		long[] d = new long[67 + 1];
		d[0] = 1;
		d[1] = 1;
		d[2] = 2;
		d[3] = 4;

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			for (int j = 4; j <= n; j++) {
				d[j] = d[j - 1] + d[j - 2] + d[j - 3] + d[j - 4];
			}
			System.out.println(d[n]);
		}
	}
}