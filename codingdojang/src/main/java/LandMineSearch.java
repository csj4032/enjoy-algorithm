import java.util.Scanner;

import static java.lang.System.in;

public class LandMineSearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		String[][] a = new String[n][m];

		for (int i = 0; i < n; i++) {
			String[] line = sc.next().split("");
			for (int j = 0; j < m; j++) {
				a[i][j] = "0";
				if (line[j].equals("*")) a[i][j] = "*";
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j].equals("*")) {

					if (j - 1 >= 0) {
						String b = a[i][j - 1];
						a[i][j - 1] = String.valueOf(Integer.valueOf(b) + 1);
					}

					if (i - 1 >= 0 && j - 1 >= 0) {
						String b = a[i - 1][j - 1];
						a[i - 1][j - 1] = String.valueOf(Integer.valueOf(b) + 1);
					}

					if (i - 1 >= 0) {
						String b = a[i - 1][j];
						a[i - 1][j] = String.valueOf(Integer.valueOf(b) + 1);
					}

					if (i - 1 >= 0 && j + 1 < 4) {
						String b = a[i - 1][j + 1];
						a[i - 1][j + 1] = String.valueOf(Integer.valueOf(b) + 1);
					}

					if (j + 1 < 4) {
						String b = a[i][j + 1];
						a[i][j + 1] = String.valueOf(Integer.valueOf(b) + 1);
					}

					if (i + 1 < n && j + 1 < m) {
						String b = a[i + 1][j + 1];
						a[i + 1][j + 1] = String.valueOf(Integer.valueOf(b) + 1);
					}

					if (i + 1 < n) {
						String b = a[i + 1][j];
						a[i + 1][j] = String.valueOf(Integer.valueOf(b) + 1);
					}

					if (i + 1 < n && j - 1 >= 0) {
						String b = a[i + 1][j - 1];
						a[i + 1][j - 1] = String.valueOf(Integer.valueOf(b) + 1);
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
}