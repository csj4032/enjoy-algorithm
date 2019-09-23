package p2357;

import java.util.Scanner;

public class Main {

	static int[] numbers;
	static int[] tree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int m = sc.nextInt();
		numbers = new int[n];
		tree = new int[100];

		for (int i = 0; i < n; i++) numbers[i] = sc.nextInt();
		segment(1, 0, numbers.length - 1);
		for (int i = 0; i < m; i++) {
			int r = query(sc.nextInt() - 1, sc.nextInt() - 1, 1, 0, numbers.length);
			System.out.println(r);
		}
	}

	private static int segment(int node, int start, int end) {
		if (start == end) {
			tree[node - 1] = numbers[start];
			return tree[node - 1];
		}
		int mid = (start + end) / 2;
		int r = segment(node * 2, start, mid);
		int l = segment(node * 2 + 1, mid + 1, end);
		tree[node - 1] = Math.max(r, l);
		return tree[node - 1];
	}

	private static int query(int left, int right, int node, int start, int end) {
		if (end < left || right < start) return 0;
		if (left <= start && right >= end) return tree[node - 1];
		int mid = (start + end) / 2;
		int r = query(left, right, node * 2, start, mid);
		int l = query(left, right, node * 2 + 1, mid + 1, end);
		return Math.max(r, l);
	}
}
