package levelTwo;

import java.util.ArrayDeque;
import java.util.Queue;

public class RotateMatrixBorders {

	private int[][] board;

	public RotateMatrixBorders(int rows, int columns) {
		init(rows, columns);
	}

	private void init(int rows, int columns) {
		board = new int[rows][columns];
		int number = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				board[i][j] = number;
				number++;
			}
		}
	}

	public int[] queries(int[][] queries) {
		int length = queries.length;
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			int r1 = queries[i][0] - 1;
			int c1 = queries[i][1] - 1;
			int r2 = queries[i][2] - 1;
			int c2 = queries[i][3] - 1;
			ArrayDeque<Integer> values = new ArrayDeque();
			ArrayDeque<int[]> points = new ArrayDeque();
			top(r1, c1, r1 + 1, c2 + 1, values, points);
			left(r1 + 1, c2, r2 + 1, c2 + 1, values, points);
			bottom(r2, c2 - 1, r2 + 1, c1 - 1, values, points);
			right(r2 - 1, c1, r1, c1 + 1, values, points);
			result[i] = values.stream().mapToInt(e -> e).min().getAsInt();
			values.addFirst(values.removeLast());
			int size = values.size();
			for (int j = 0; j < size; j++) {
				int[] point = points.removeFirst();
				Integer value = values.removeFirst();
				board[point[0]][point[1]] = value;
			}
			// System.out.println(Arrays.deepToString(board));
		}
		return result;
	}

	private void top(int r1, int c1, int r2, int c2, Queue<Integer> values, Queue<int[]> points) {
		for (int i = r1; i < r2; i++) {
			for (int j = c1; j < c2; j++) {
				values.add(board[i][j]);
				points.add(new int[]{i, j});
			}
		}
	}

	private void left(int r1, int c1, int r2, int c2, Queue values, Queue<int[]> points) {
		for (int i = r1; i < r2; i++) {
			for (int j = c1; j < c2; j++) {
				values.add(board[i][j]);
				points.add(new int[]{i, j});
			}
		}
	}

	private void bottom(int r1, int c1, int r2, int c2, Queue values, Queue<int[]> points) {
		for (int i = r1; i < r2; i++) {
			for (int j = c1; j > c2; j--) {
				values.add(board[i][j]);
				points.add(new int[]{i, j});
			}
		}
	}

	private void right(int r1, int c1, int r2, int c2, Queue<Integer> values, Queue<int[]> points) {
		for (int i = r1; i > r2; i--) {
			for (int j = c1; j < c2; j++) {
				values.add(board[i][j]);
				points.add(new int[]{i, j});
			}
		}
	}
}
