package com.genius.apss.chap08;

public class JumpGame {

	private int n = 0;
	private int[][] board;
	private int[][] cache;

	public JumpGame(int n, int[][] board, int[][] cache) {
		this.n = n;
		this.board = board;
		this.cache = cache;
	}

	private boolean jump(int y, int x) {
		if (y >= n || x >= n) return false;
		if (y == n - 1 && x == n - 1) return true;
		int jumpSize = board[y][x];
		return jump(y + jumpSize, x) || jump(y, x + jumpSize);
	}

	private int jump2(int y, int x) {
		if (y >= n || x >= n) return 0;
		if (y == n - 1 && x == n - 1) return 1;
		int ret = cache[y][x];
		if (ret != 0) return ret;
		int jumpSize = board[y][x];
		return ret = (jump2(y + jumpSize, x) | jump2(y, x + jumpSize));
	}

	public static void main(String[] args) {
		int n = 7;
		int[][] board = new int[n][n];
		int[][] cache = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = 1;
			}
		}
		board[0] = new int[]{2, 5, 1, 6, 1, 4, 1};
		board[1] = new int[]{6, 1, 1, 2, 2, 9, 3};
		board[2] = new int[]{7, 2, 3, 2, 1, 3, 1};
		board[3] = new int[]{2, 1, 3, 1, 7, 1, 2};
		board[4] = new int[]{4, 1, 2, 3, 4, 1, 2};
		board[5] = new int[]{3, 3, 1, 2, 3, 4, 1};
		board[6] = new int[]{1, 5, 2, 9, 4, 7, 0};

		JumpGame jumpGame = new JumpGame(7, board, cache);
		System.out.println(jumpGame.jump(0, 0));
		System.out.println(jumpGame.jump2(0, 0));
	}
}
