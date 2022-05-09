package levelThree;

import java.util.Arrays;

public class NQueen {

	private boolean[][] board;
	int answer = 0;

	public int solution(int n) {
		board = new boolean[n][n];
		recursive(0, 0, 0);
		return answer;
	}

	private void recursive(int n, int y, int x) {
		if (!promising(n, y, x)) {
			board[y][x] = true;
			return;
		}

		System.out.println(Arrays.deepToString(board));
		for (int i = y; i < n; i++) {
			for (int j = x; j < n; j++) {
				board[i][j] = true;
				recursive(n, i, j);
			}
		}
		answer++;
	}

	private boolean promising(int n, int y, int x) {

		// row
		for (int i = 0; i < n; i++) {
			if (board[i][x]) {
				return false;
			}
		}

		// col
		for (int i = 0; i < n; i++) {
			if (board[y][i]) {
				return false;
			}
		}

//		int z = Math.min(x, y);
//		int w = Math.max(x, y);
//		int j = y - z;
//		int k = x - z;
//		int l = n - w;
//		for (int i = 0; i < l; i++) {
//			if (board[j + i][k + i]) {
//				return false;
//			}
//		}

		return true;
	}
}
