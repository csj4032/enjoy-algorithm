package p2630;

import java.util.Scanner;

public class Main {

	static int[][] m;
	static int n;
	static int white;
	static int blue;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		m = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				m[i][j] = sc.nextInt();
			}
		}
		recursive(0, 0, n);
		System.out.println(white);
		System.out.println(blue);
	}

	private static void recursive(int x1, int y1, int size) {
		if (size < 1) return;
		int color = m[y1][x1];
		if (check(x1, y1, size, color)) {
			if (color == 1) blue++;
			else white++;
			return;
		}
		size >>>= 1;
		recursive(x1, y1, size);
		recursive(x1 + size, y1, size);
		recursive(x1, y1 + size, size);
		recursive(x1 + size, y1 + size, size);
	}

	private static boolean check(int x1, int y1, int size, int color) {
		for (int i = y1; i < y1 + size; i++) {
			for (int j = x1; j < x1 + size; j++) {
				if (color != m[i][j]) return false;
			}
		}
		return true;
	}
}
