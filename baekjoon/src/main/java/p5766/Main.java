package p5766;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var sb = new StringBuilder();
		while (true) {
			var n = sc.nextInt();
			var m = sc.nextInt();
			if (n == 0 && m == 0) break;
			int[] rank = new int[10001];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					var k = sc.nextInt();
					rank[k]++;
				}
			}

			int[][] bool = new int[3][10001];
			int k = 1;
			for (int i = 500; i > 0; i--) {
				var f = false;
				for (int j = 1; j < 10001; j++) {
					if (i == rank[j]) {
						bool[k][j] = 1;
						f = true;
					}
				}
				if (f) k++;
				if (k > 2) break;
			}

			for (int i = 0; i < bool[2].length; i++) if (bool[2][i] == 1) sb.append(i + " ");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}