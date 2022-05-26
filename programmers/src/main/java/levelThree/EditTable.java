package levelThree;

import java.util.ArrayList;
import java.util.Stack;

public class EditTable {

	public String solution(int n, int k, String[] cmd) {
		int length = cmd.length;
		Stack<Row> undo = new Stack();
		StringBuffer sb = new StringBuffer();
		ArrayList<Integer> linkedList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			sb.append("O");
			linkedList.add(i);
		}

		int current = k;
		for (int i = 0; i < length; i++) {
			String commend = cmd[i];
			if (commend.equals("C")) {
				//System.out.println("C" + " " + current);
				current = delete(current, linkedList, undo);
			} else if (commend.equals("Z")) {
				//System.out.println("Z" + " " + current);
				current = undo(current, linkedList, undo);
			} else if (commend.contains("U")) {
				Integer count = Integer.valueOf(commend.split(" ")[1]);
				//System.out.println("U" + " " + current + " " + count);
				current = up(current, count);
			} else if (commend.contains("D")) {
				Integer count = Integer.valueOf(commend.split(" ")[1]);
				//System.out.println("D" + " " + current + " " + count);
				current = down(current, count);
			}
			//System.out.println(linkedList);
		}

		while (!undo.isEmpty()) {
			sb.setCharAt(undo.pop().value, 'X');
		}

		return sb.toString();
	}

	private int down(int current, int move) {
		return current + move;
	}

	private int up(int current, int move) {
		return current - move;
	}

	public int delete(int current, ArrayList<Integer> linkedList, Stack<Row> undo) {
		undo.add(new Row(current, linkedList.remove(current)));
		if ((linkedList.size()) == current) current--;
		return current;
	}

	public int undo(int current, ArrayList<Integer> linkedList, Stack<Row> undo) {
		Row row = undo.pop();
		int index = row.index;
		int value = row.value;
		if (index <= current) current++;
		linkedList.add(index, value);
		return current;
	}
}

class Row {
	int index;
	int value;

	public Row(int index, int value) {
		this.index = index;
		this.value = value;
	}
}
