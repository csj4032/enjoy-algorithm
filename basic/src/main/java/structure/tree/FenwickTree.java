package structure.tree;

import java.util.Arrays;
import java.util.Scanner;

public class FenwickTree {

	static int[] array;
	static int[] tree;

	public static void update(int[] tree, int i, int diff) {
		while (i < tree.length) {
			tree[i] += diff;
			i += (i & -i);
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		array = new int[n + 1];
		tree = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			array[i] = sc.nextInt();
			update(tree, i, array[i]);
		}

		System.out.println(Arrays.toString(tree));
	}
}