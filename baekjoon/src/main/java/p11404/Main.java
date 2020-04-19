package p11404;

import java.util.Scanner;

public class Main {

	public static final int INF = 1000_000_000;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] distance = new int[n+1][n+1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(i == j) continue;
				distance[i][j] = INF;
			}
		}

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			distance[x][y] = Math.min(distance[x][y], d);
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (distance[i][j] >= INF) {
					sb.append("0 ");
				} else {
					sb.append(distance[i][j] + " ");
				}
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}