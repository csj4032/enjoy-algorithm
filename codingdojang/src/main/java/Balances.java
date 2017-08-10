import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class Balances {

	static int w[][];
	static int d[][];

	public static void main(String[] args) {

		Scanner sc = new Scanner(in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		w = new int[m][2];
		d = new int[n][n];

		for (int i = 0; i < m; i++) {
			w[i][0] = sc.nextInt();
			w[i][1] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				d[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int a = w[j][0];
				int b = w[j][1];
				d[a - 1][b - 1] = 1;
			}
		}

		System.out.println(Arrays.deepToString(d));

	}
}