package recursion;

import java.util.Scanner;

public class ArrayAndRecursion {

	public int sum(int n, int[] data) {
		if (n <= 0) {
			return 0;
		} else {
			return sum(n - 1, data) + data[n - 1];
		}
	}

	public void readFrom(int n, int[] data, Scanner in) {
		if (n == 0) {
			return;
		} else {
			readFrom(n - 1, data, in);
			data[n - 1] = in.nextInt();
		}
	}
}
