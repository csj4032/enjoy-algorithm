package levelThree;

public class NQueen {

	private int[] cols;
	private int size = 0;
	private int answer = 0;

	public int solution(int n) {
		size = n;
		cols = new int[n + 1];
		recursive(0);
		return answer;
	}

	private boolean recursive(int row) {
		if (!promising(row)) {
			return false;
		} else if (row == size) {
			answer++;
			return true;
		}

		for (int i = 1; i <= size; i++) {
			cols[row + 1] = i;
			if (recursive(row + 1)) return false;
		}
		return false;
	}

	private boolean promising(int row) {
		for (int i = 1; i < row; i++) {
			if (cols[i] == cols[row]) return false;
			if ((row - i) == Math.abs(cols[row] - cols[i])) return false;
		}
		return true;
	}
}
