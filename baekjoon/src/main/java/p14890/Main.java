package p14890;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int n;
	static int l;
	static int k;
	static Info[][] map;
	static Info[] v;
	static Info[] h;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		l = sc.nextInt();
		map = new Info[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = new Info(sc.nextInt(), 0);
			}
		}

		outer:
		for (int i = 0; i < n; i++) {
			h = copyRow(map, i);
			var ww = true;
			var wc = true;
			var prev = h[0];
			for (int j = 1; j < n; j++) {
				var current = h[j];
				if (prev.value != current.value && !check(h, l, j, current, prev)) {
					ww = false;
					break;
				}
				prev = current;
			}

			for (int j = n - 1; j >= 0; j--) {

			}
			if (ww && wc) k++;
		}

		for (
				int i = 0;
				i < n; i++) {
			v = copyCol(map, i);
		}

		System.out.println(k);
	}

	private static boolean check(Info[] row, int size, int distance, Info current, Info prev) {
		var count = size * Math.abs(current.value - prev.value);
		if (count > distance) return false;
		while (count-- > 0) {
			var tt = row[--distance].value;
			if (tt != prev.value) {
				return false;
			}
		}
		return true;
	}

	private static Info[] copyRow(Info[][] map, int idx) {
		var newRow = new Info[n];
		for (int i = 0; i < n; i++) {
			newRow[i] = map[idx][i];
		}
		return newRow;
	}

	private static Info[] copyCol(Info[][] map, int idx) {
		var newCol = new Info[n];
		for (int i = 0; i < n; i++) {
			newCol[i] = map[i][idx];
		}
		return newCol;
	}
}

class Info {
	int value;
	int slope;

	public Info(int value, int slope) {
		this.value = value;
		this.slope = slope;
	}

	@Override
	public String toString() {
		return "Info{" +
				"value=" + value +
				", slope=" + slope +
				'}';
	}
}