package levelTwo;

import java.util.ArrayList;
import java.util.List;

public class RotateMatrixBordersCell {

	private List<Cell> cells;

	public RotateMatrixBordersCell(int rows, int columns) {
		init(rows, columns);
	}

	private void init(int rows, int columns) {
		int value = 1;
		cells = new ArrayList<>();
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) cells.add(new Cell(i, j, value++));
		}
	}

	public int[] queries(int[][] queries) {
		int length = queries.length;
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			int[] query = queries[i];
			cells.stream().forEach(e -> e.update(query));
			result[i] = cells.stream().filter(e -> !e.getPosition().equals(Position.NONE)).mapToInt(e -> e.getValue()).min().getAsInt();
		}
		return result;
	}
}

enum Position {
	LEFT,
	TOP,
	RIGHT,
	BOTTOM,
	NONE,
}

class Cell {
	private Integer row;
	private Integer col;
	private Integer value;
	private Position position;

	public Cell(Integer row, Integer col, Integer value) {
		this.row = row;
		this.col = col;
		this.value = value;
		this.position = Position.NONE;
	}

	public Cell update(int[] query) {
		boarder(query[0], query[1], query[2], query[3]);
		rotation();
		return this;
	}

	private void rotation() {
		if (this.position.equals(Position.TOP)) this.col = this.col + 1;
		if (this.position.equals(Position.RIGHT)) this.row = this.row + 1;
		if (this.position.equals(Position.BOTTOM)) this.col = this.col - 1;
		if (this.position.equals(Position.LEFT)) this.row = this.row - 1;
	}

	private void boarder(int r1, int c1, int r2, int c2) {
		this.position = Position.NONE;
		if (r1 == row & (c1 <= col & c2 > col)) this.position = Position.TOP;
		if (c2 == col & (r1 <= row & r2 > row)) this.position = Position.RIGHT;
		if (r2 == row & (c1 < col & c2 >= col)) this.position = Position.BOTTOM;
		if (c1 == col & (r1 < row & r2 >= row)) this.position = Position.LEFT;
	}

	public Integer getValue() {
		return value;
	}

	public Position getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return "Cell{" +
				"row=" + row +
				", col=" + col +
				", value=" + value +
				", position=" + position +
				'}';
	}
}
