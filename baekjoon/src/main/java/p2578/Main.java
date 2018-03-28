package p2578;

import java.util.Scanner;

public class Main {

	static int col = 5;
	static int row = 5;
	static int bingLine = 3;
	static int[][] board = new int[row][col];
	static int[] numbers = new int[row * col];

	public static void main(String[] args) {
		boardAndNumbersInit();
		System.out.println(boardMarking());
	}

	private static int boardMarking() {
		for (int i = 0; i < row * col; i++) {
			int target = numbers[i];
			for (int j = 0; j < row; j++) {
				for (int k = 0; k < col; k++) {
					if (target == board[j][k]) {
						board[j][k] = 0;
						if (bingSearch()) return i + 1;
					}
				}
			}
		}
		return 0;
	}

	private static boolean bingSearch() {
		int line = 0;
		int diagonalR = 0;
		int diagonalL = 0;
		for (int i = 0; i < row; i++) {
			int cols = 0;
			int rows = 0;
			for (int j = 0; j < col; j++) {
				cols += board[i][j];
				rows += board[j][i];
				if (i == j) diagonalL += board[i][j];
				if (i == col - 1 - j) diagonalR += board[i][j];
			}
			if (cols == 0) line++;
			if (rows == 0) line++;
		}
		if (diagonalL == 0) line++;
		if (diagonalR == 0) line++;
		return line >= bingLine ? true : false;
	}

	private static void boardAndNumbersInit() {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < row * col; i++) {
			numbers[i] = sc.nextInt();
		}
	}
}