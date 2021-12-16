package winterCoding2019;

import java.util.*;

public class CraneDoll {

	private int bomb;
	private Board board;
	private Deque<Doll> basket;

	public CraneDoll(int[][] board) {
		this.board = new Board(board);
		this.basket = new ArrayDeque<>();
	}

	public boolean isEmptyDoll(int col) {
		if (null == board.peekOfColumn(col)) return true;
		return false;
	}

	public void addBasket(int col) {
		if (!isEmptyDoll(col)) {
			Doll doll = board.popOfColumn(col);
			Doll target = basket.peek();
			if (target != null && doll.getCharacter().equals(target.getCharacter())) {
				bomb += 2;
				basket.pop();
			} else {
				basket.push(doll);
			}
		}
		System.out.println("bomb :" + bomb);
	}

	public int getBomb() {
		return bomb;
	}
}

class Board {

	private Map<Integer, Queue<Doll>> map = new HashMap();

	public Board(int[][] board) {
		init(board);
	}

	public void init(int[][] board) {
		int len = board.length;
		for (int col = 0; col < len; col++) {
			Queue<Doll> dolls = new ArrayDeque<>();
			for (int row = 0; row < len; row++) {
				int character = board[row][col];
				if (character != 0) dolls.add(new Doll(character, new Point(row, col)));
			}
			map.put(col + 1, dolls);
		}
	}

	public Doll popOfColumn(int col) {
		return map.get(col).poll();
	}

	public Doll peekOfColumn(int col) {
		return map.get(col).peek();
	}
}

class Doll {
	private Integer character;
	private Point point;

	public Doll(Integer character, Point point) {
		this.character = character;
		this.point = point;
	}

	public Integer getCharacter() {
		return character;
	}
}

class Point {
	private int row;
	private int col;

	public Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
}
