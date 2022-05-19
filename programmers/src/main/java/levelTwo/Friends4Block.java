package levelTwo;

import java.util.Arrays;

public class Friends4Block {

	static Integer[][] directX = new Integer[][]{{0, 1, 1}, {1, 1, 0}, {0, -1, -1}, {-1, -1, 0}};
	static Integer[][] directY = new Integer[][]{{-1, -1, 0}, {0, 1, 1}, {1, 1, 0}, {0, -1, -1}};

	public int solution(int m, int n, String[] board) {
		int answer = 0;
		String[][] grid = new String[m][n];

		for (int i = 0; i < m; i++) grid[i] = board[i].split("");

		while (true) {
			boolean[][] checked = search(m, n, grid);
			int count = counter(m, n, checked);
			if (count == 0) break;
			answer += count;
			int[] marked = marker(m, n, checked, grid);
			move(m, n, marked, grid);
		}

		return answer;
	}

	private void move(int m, int n, int[] marked, String[][] grid) {
		for (int i = m - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				if (!grid[i][j].equals(" ") && marked[j] > i) {
					grid[i + marked[j] - i][j] = grid[i][j];
					grid[i][j] = " ";
					marked[j]--;
				}
			}
		}
	}

	private void display(int m, int n, String[][] array) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}

	private int counter(int m, int n, boolean[][] checked) {
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (checked[i][j]) count++;
			}
		}
		return count;
	}

	private int[] marker(int m, int n, boolean[][] checked, String[][] grid) {
		int[] marked = new int[n];
		Arrays.fill(marked, -1);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (checked[i][j]) {
					grid[i][j] = " ";
					marked[j] = i;
				}
			}
		}
		return marked;
	}

	private boolean[][] search(int m, int n, String[][] grid) {
		boolean[][] checked = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (checker(grid, i, j, m, n)) {
					checked[i][j] = true;
				}
			}
		}
		return checked;
	}

	private boolean checker(String[][] grid, int i, int j, int m, int n) {
		String target = grid[i][j];
		if (target.equals(" ")) return false;
		for (int k = 0; k < 4; k++) {
			int t = 0;
			for (int l = 0; l < 3; l++) {
				int ii = i + directY[k][l];
				int jj = j + directX[k][l];
				if (ii < 0 || ii >= m || jj < 0 || jj >= n) continue;
				if (target.equals(grid[ii][jj])) {
					t++;
				}
				if (t >= 3) {
					return true;
				}
			}
		}
		return false;
	}
}
