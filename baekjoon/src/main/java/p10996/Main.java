package p10996;

import java.util.Scanner;

/**
 * 제목 : 별 찍기 - 21
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = n * 2;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (((j + i) & 1) == 0) {
					System.out.print("*");
				} else {
					if (j < n - 1 && i <= m - 1) System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}