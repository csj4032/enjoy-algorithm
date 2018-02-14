package p10178;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] m = new int[n][2];

		for (int i = 0; i < n; i++) {
			m[i][0] = sc.nextInt();
			m[i][1] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			System.out.printf("You get %d piece(s) and your dad gets %d piece(s).\n", (m[i][0] - m[i][0] % m[i][1]) / m[i][1], m[i][0] % m[i][1]);
		}
	}
}