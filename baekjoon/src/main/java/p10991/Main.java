package p10991;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = n * 2 - 1;
		char[][] m = new char[n][l];

		for (int i = 0; i < n; i++) {
			Arrays.fill(m[i], ' ');
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				m[i][(n - i - 1) + (j * 2)] = '*';
			}
		}

		for (int i = 0; i < n; i++) {
			int star = 0;
			for (int j = 0; j < l; j++) {
				char c = m[i][j];
				if (c == '*') {
					star++;
				}
				System.out.print(m[i][j]);
				if (star == i + 1) {
					break;
				}
			}
			System.out.println("");
		}
	}
}