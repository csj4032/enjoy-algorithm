package p10994;

import java.util.Scanner;

public class Main {

	static int q;
	static String s[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		display(n);
	}

	private static void display(int n) {
		q = ((n - 1) * 4) + 1;
		s = new String[q][q];
		for (int i = n; i > 0; i--) {
			int t = ((i - 1) * 4) + 1;
			int p = ((q - t) / 2);
			int l = t + p;
			for (int j = p; j < l; j++) {
				for (int k = p; k < l; k++) {
					if (j == p || j == l - 1 || k == p || k == l - 1 || (j == p && k == p)) {
						s[j][k] = "*";
					} else {
						s[j][k] = " ";
					}
				}
			}
		}
		for (int i = 0; i < q; i++) {
			for (int j = 0; j < q; j++) {
				System.out.print(s[i][j]);
			}
			System.out.println();
		}
	}
}