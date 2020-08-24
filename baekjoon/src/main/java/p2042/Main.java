package p2042;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	private static int nn[];
	private static int node[];
	private int k;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var m = sc.nextInt();
		var k = sc.nextInt();
		nn = new int[n];
		node = new int[n * n];
		for (int i = 0; i < n; i++) nn[i] = sc.nextInt();

		init(nn, node, 1, 0, n - 1);

		System.out.println(Arrays.toString(node));

		for (int i = 0; i < m + k; i++) {
			var a = sc.nextInt();
			var b = sc.nextInt();
			var c = sc.nextInt();
			if (a == 1) {

			} else {

			}
		}
	}

	private static int init(int[] nn, int[] node, int idx, int start, int end) {
		if (start == end) {
			return node[idx] = nn[start];
		}
		return node[idx] = init(nn, node, idx * 2, start, (start + end) / 2) + init(nn, node, idx * 2 + 1, (start + end) / 2 + 1, end);
	}
}
