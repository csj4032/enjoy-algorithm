package medium;

public class NumberOfClosedIslands {

	int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public int closedIsland(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		int result = 0;

		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(grid[i][j] == 0 && isLand(i,j, grid, rows, cols)){
					result++;
				}
			}
		}
		return result;
	}

	private boolean isLand(int row, int col, int[][] grid, int rows, int cols) {
		if(row < 0 || row >= rows || col < 0 || col >= cols ) return false;
		if(grid[row][col] == 1) return true;
		grid[row][col] = 1;

		boolean result = true;
		for(int[] d : dir) {
			result = result & isLand(row+d[0], col+d[1], grid, rows, cols);
		}
		return result;
	}
}
