package levelTwo;

import java.util.ArrayList;
import java.util.List;

public class TriangularSnail {

	public int[] solution(int n) {
		List<Integer> list = new ArrayList<>();
		int[][] grid = new int[n][n];
		int[] dx = new int[]{0, 1, -1};
		int[] dy = new int[]{1, 0, -1};
		int x = 0;
		int y = 0;
		int k = 0;
		int t = 1;
		for (int i = n; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				x = x + dx[k % 3];
				y = y + dy[k % 3];
				grid[y - 1][x] = t++;
			}
			k++;
		}
		display(n, grid);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] > 0) {
					list.add(grid[i][j]);
				}
			}
		}
		return list.stream().mapToInt(e -> e.intValue()).toArray();
	}

	private void display(int n, int[][] grid) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
}