package p9663;

import java.util.Scanner;

public class Main {

	static int n;
	static int[] cols;
	static int k;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		cols = new int[n+1];
		recursive(0);
		System.out.println(k);
	}

	private static boolean recursive(int row) {
		if (!promising(row)) {
			return false;
		} else if (row == n) {
			k++;
			return true;
		}

		for (int i = 1; i <= n; i++) {
			cols[row + 1] = i;
			if (recursive(row + 1)) return false;
		}
		return false;
	}

	private static boolean promising(int row) {
		for (int i = 1; i < row; i++) {
			if (cols[i] == cols[row]) return false;
			if ((row - i) == Math.abs(cols[row] - cols[i])) return false;
		}
		return true;
	}
}