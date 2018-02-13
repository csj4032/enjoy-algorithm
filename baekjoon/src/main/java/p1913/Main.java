package p1913;

import java.util.Scanner;

public class Main {

	static int[][] d = new int[4][2];
	static int p = 4;

	static {
		d[0][0] = 1;
		d[0][1] = 0;

		d[1][0] = 0;
		d[1][1] = 1;

		d[2][0] = -1;
		d[2][1] = 0;

		d[3][0] = 0;
		d[3][1] = -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] t = new int[n][n];
		int k = n * n;
		int q = 0;
		int r = -1;
		int c = 0;

		for (int i = n; i > 0; i--) {
			for (int j = 0; j < 2; j++) {
				if (!(i == n && j == 0)) {
					for (int l = 0; l < i; l++) {
						r += d[q % p][0];
						c += d[q % p][1];
						t[r][c] = k;
						k--;
					}
					q++;
				}
			}
		}

		int tx = 0;
		int ty = 0;
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				sb.append(t[i][j]);
				sb.append(" ");
				if (m == t[i][j]) {
					tx = j + 1;
					ty = i + 1;
				}
			}
			System.out.println(sb.toString().trim());
		}

		System.out.println(ty + " " + tx);
	}
}