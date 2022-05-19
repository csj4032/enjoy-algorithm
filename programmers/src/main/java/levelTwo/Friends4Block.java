package levelTwo;

public class Friends4Block {

	static Integer[][] directX = new Integer[][]{{0, 1, 1}, {1, 1, 0}, {-1, -1, 1}, {1, 1, 1}};
	static Integer[][] directY = new Integer[][]{{0, 1, 1}, {1, 1, 0}, {-1, -1, 1}, {1, 1, 1}};

	public int solution(int m, int n, String[] board) {
		String[][] grid = new String[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = String.valueOf(board[i].charAt(j));
			}
		}

		boolean bomb = false;
		int bombCount = 0;

		while (true) {
			if (bomb) break;
		}

		int answer = 0;
		return answer;
	}

	private boolean[][] search(int m, int n, String[][] grid) {
		boolean[][] checked = new boolean[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (checked(grid, i, j, m, n)) {
					checked[i][j] = true;
				}
			}
		}
		return checked;
	}

	private boolean checked(String[][] grid, int i, int j, int m, int n) {
		String target = grid[i][j];
		for (int k = 0; k < 4; k++) {
			int t = 0;
			for (int l = 0; l < 3; l++) {
				int ii = i + directY[k][l];
				int jj = j + directX[k][l];
				if (ii < 0 || ii > m || jj < 0 || jj > n) continue;
				if (target.equals(grid[ii][jj])) {
					t++;
				}

			}
		}
		return false;
	}
}
