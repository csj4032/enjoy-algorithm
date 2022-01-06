package levelTwo;

/**
 * 무식 반복 성능 안나옴
 * **/
public class LargestSquare {

	public int area(int[][] board) {
		int rows = board.length;
		int cols = board[0].length;
		int max_area = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == 0) continue;
				int length = Math.min(rows - i, cols - j);
				for (int k = 1; k <= length; k++) {
					int count = area(board, i, j, k);
					if (count == 0) break;
					max_area = Math.max(count, max_area);
				}
			}
		}
		return max_area;
	}

	private int area(int[][] board, int i, int j, int length) {
		int count = 0;
		outer:
		for (int l = i; l < i + length; l++) {
			for (int m = j; m < j + length; m++) {
				if (board[l][m] == 0) {
					count = 0;
					break outer;
				}
				count++;
			}
		}
		return count;
	}
}