package p2167;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		int k = sc.nextInt();

		while (k-- > 0) {
			int i = sc.nextInt() - 1;
			int j = sc.nextInt() - 1;
			int x = sc.nextInt();
			int y = sc.nextInt();
			int sum = 0;
			for (int l = i; l < x; l++) {
				for (int q = j; q < y; q++) {
					sum += (a[l][q]);
				}
			}
			System.out.println(sum);
		}
		sc.close();
	}
}