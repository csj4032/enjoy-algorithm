package p11004;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] m = new int[n];

		for (int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
		}

		System.out.println(quickSelect(m, m.length, k - 1));
	}

	private static int quickSelect(int[] array, int length, int k) {

		if (array == null || length <= k) return -1;

		int from = 0;
		int to = length - 1;

		while (from < to) {

			int i = from;
			int j = to;
			int mid = array[(i + j) / 2];

			while (i < j) {
				if (array[i] >= mid) {
					swap(array, i, j);
					j--;
				} else {
					i++;
				}
			}

			if (array[i] > mid) i--;

			if (k <= i) {
				to = i;
			} else {
				from = i + 1;
			}
		}
		return array[k];
	}

	private static void swap(int[] array, int i, int j) {
		int tmp = array[j];
		array[j] = array[i];
		array[i] = tmp;
	}
}