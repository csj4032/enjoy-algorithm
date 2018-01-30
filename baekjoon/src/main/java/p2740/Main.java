package p2740;

import java.util.Scanner;

// 행렬 곱셈
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a1 = sc.nextInt();
		int b1 = sc.nextInt();

		int[][] m1 = new int[101][101];

		for (int i = 0; i < a1; i++) {
			for (int j = 0; j < b1; j++) {
				m1[i][j] = sc.nextInt();
			}
		}

		int a2 = sc.nextInt();
		int b2 = sc.nextInt();

		int[][] m2 = new int[101][101];

		for (int i = 0; i < a2; i++) {
			for (int j = 0; j < b2; j++) {
				m2[i][j] = sc.nextInt();
			}
		}

		int[][] m3 = new int[101][101];

		for (int i = 0; i < a1; i++) {
			for (int j = 0; j < b2; j++) {
				for (int k = 0; k < a2; k++) {
					m3[i][j] += (m1[i][k] * m2[k][j]);
				}
			}
		}

		for (int i = 0; i < a1; i++) {
			for (int j = 0; j < b2; j++) {
				System.out.print(m3[i][j] + (j == b2 - 1 ? "" : " "));
			}
			System.out.println("");
		}
	}
}