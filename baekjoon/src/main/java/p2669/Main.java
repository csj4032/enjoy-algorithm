package p2669;

import java.util.Scanner;

public class Main {

	static int map[][] = new int[101][101];
	static int k;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			var x1 = sc.nextInt();
			var y1 = sc.nextInt();
			var x2 = sc.nextInt();
			var y2 = sc.nextInt();
			for (int j = y1; j < y2; j++) {
				for (int k = x1; k < x2; k++) {
					map[j][k] = 1;
				}
			}
		}

		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				k += map[i][j];
			}
		}

		System.out.println(k);
	}
}