package p2580;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int[][] board = new int[9][9];
	static List<Point> xys = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = sc.nextInt();
				if (board[i][j] == 0) xys.add(new Point(i, j));
			}
		}
		sudoku(0);
		System.out.println(Arrays.deepToString(board));
	}

	private static void sudoku(int k) {
		if (xys.size() == k) {
			return;
		}

		for (int i = 1; i < 10; i++) {
			Point point = xys.get(k);
			if (promising(point, i)) {
				board[point.y][point.x] = i;
				sudoku(k + 1);
				board[point.y][point.x] = 0;
			}
		}
	}

	private static boolean promising(Point point, int n) {
		for (int i = 0; i < 9; i++) {
			if (board[point.y][i] == n) return false;
		}
		for (int i = 0; i < 9; i++) {
			if (board[i][point.x] == n) return false;
		}
		int yy = point.y / 3;
		int xx = point.x / 3;
		for (int i = yy * 3; i < (yy * 3) + 3; i++) {
			for (int j = xx * 3; j < (xx * 3) + 3; j++) {
				if (board[i][j] == n) return false;
			}
		}
		return true;
	}
}

@ToString
class Point {
	int y;
	int x;

	public Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}