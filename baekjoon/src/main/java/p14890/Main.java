package p14890;

import java.util.Scanner;

/**
 * 제목 : 경사로
 * 링크 : https://www.acmicpc.net/problem/14890
 * 분류 : 구현
 * 기출 : 삼성 SW 역량 테스트 기출 문제
 */
public class Main {

	static int n;
	static int l;
	static int k;
	static Info[][] map;

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

		for (int i = 0; i < n; i++) {
			if (isSlope(true, copyRow(map, i))) k++;
		}

		for (int i = 0; i < n; i++) {
			if (isSlope(true, copyCol(map, i))) k++;
		}

		System.out.println(k);
	}

	private static boolean isSlope(boolean ww, Info[] h) {
		var prev = h[0];
		for (int j = 1; j < n; j++) {
			var current = h[j];
			if (prev.value != current.value && !check(h, l, j, current, prev)) {
				ww = false;
				break;
			}
			prev = current;
		}
		return ww;
	}

	private static boolean check(Info[] row, int size, int distance, Info current, Info prev) {
		var count = size * Math.abs(current.value - prev.value);
		if (current.value < prev.value) {
			if (count + distance > row.length) return false;
			while (count-- > 0) {
				var tt = row[distance];
				if (tt.value != current.value || tt.slope >= 1) {
					return false;
				} else {
					row[distance].slope = count + 1;
				}
				distance++;
			}
		} else {
			if (count > distance) return false;
			while (count-- > 0) {
				var tt = row[--distance];
				if (tt.value != prev.value || tt.slope >= 1) {
					return false;
				} else {
					row[distance].slope = count + 1;
				}
			}
		}
		return true;
	}

	private static Info[] copyRow(Info[][] map, int idx) {
		var newRow = new Info[n];
		for (int i = 0; i < n; i++) {
			newRow[i] = new Info(map[idx][i].value, map[idx][i].slope);
		}
		return newRow;
	}

	private static Info[] copyCol(Info[][] map, int idx) {
		var newCol = new Info[n];
		for (int i = 0; i < n; i++) {
			newCol[i] = new Info(map[i][idx].value, map[i][idx].slope);
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

/*
6 2
3 3 3 3 3 3
2 3 3 3 3 3
2 3 3 3 3 3
1 3 3 3 3 3
1 3 3 3 3 3
1 3 3 3 3 3
 */