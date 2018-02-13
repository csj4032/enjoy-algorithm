package p2563;

import java.util.Scanner;

public class Main {

	static int w = 100;
	static int w2 = 10;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int c = 0;
		int[][] m = new int[t][2];

		for (int i = 0; i < t; i++) {
			m[i][0] = sc.nextInt();
			m[i][1] = sc.nextInt();
		}

		for (int i = 0; i < w; i++) {
			for (int j = 0; j < w; j++) {
				for (int k = 0; k < t; k++) {
					if (m[k][1] <= j && j < (m[k][1] + w2) && m[k][0] <= i && i < (m[k][0] + w2)) {
						c++;
						break;
					}
				}
			}
		}

		System.out.println(c);
	}
}