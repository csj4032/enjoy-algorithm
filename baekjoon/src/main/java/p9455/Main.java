package p9455;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] tt = new int[t];

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] nn = new int[n][m];
			int[] l = new int[m];
			int[] f = new int[m];

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					nn[j][k] = sc.nextInt();
				}
			}

			int c = 0;
			for (int j = n - 1; j >= 0; j--) {
				for (int k = m - 1; k >= 0; k--) {
					if (nn[j][k] == 1) {
						c += n - j - 1 - l[k];
						l[k] = l[k] + 1;
					}
				}
			}
			tt[i] = c;
		}

		Arrays.stream(tt).forEach(System.out::println);
	}
}
