package levelTwo;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceGameMap {

	private int[][] visited;
	private Queue<Tile> queue = new LinkedList<>();
	private int[] directY = new int[]{-1, 0, 1, 0};
	private int[] directX = new int[]{0, 1, 0, -1};

	public int solution(int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;
		visited = new int[n][m];
		queue.add(new Tile(0, 0));
		visited[0][0] = 1;
		while (!queue.isEmpty()) {
			Tile tile = queue.poll();
			if ((tile.row == (n - 1)) && (tile.col == (m - 1))) return visited[n - 1][m - 1];
			for (int i = 0; i < 4; i++) {
				int row = tile.row + directY[i];
				int col = tile.col + directX[i];
				if (row < 0 || col < 0 || row > (n - 1) || col > (m - 1)) continue;
				if ((maps[row][col] == 1) && (visited[row][col] == 0)) {
					visited[row][col] = visited[tile.row][tile.col] + 1;
					queue.add(new Tile(row, col));
				}
			}
		}
		return -1;
	}
}

class Tile {
	int row;
	int col;

	public Tile(int row, int col) {
		this.row = row;
		this.col = col;
	}

	@Override
	public String toString() {
		return "Tile{" +
				"row=" + row +
				", col=" + col +
				'}';
	}
}
