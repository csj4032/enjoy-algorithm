package p2357;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 제목 : 최솟값과 최댓값
 * 링크 : https://www.acmicpc.net/problem/2357
 * 분류 : 자료 구조, 세그먼트 트리
 */
public class Main {

	static int[] numbers;
	static int[] tree;
	static int[] tree2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = (int) Math.ceil(Math.log(n) / Math.log(2));
		numbers = new int[n];
		tree = new int[1 << (k + 1)];
		tree2 = new int[1 << (k + 1)];

		for (int i = 0; i < n; i++) numbers[i] = sc.nextInt();

		segment(1, 0, n - 1);
		segment2(1, 0, n - 1);
		System.out.println(Arrays.toString(tree));

		for (int i = 0; i < m; i++) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			int min = query2(l - 1, r - 1, 1, 0, n - 1);
			int max = query(l - 1, r - 1, 1, 0, n - 1);
			System.out.println(min + " " + max);
		}
	}

	private static int segment(int node, int start, int end) {
		if (start == end) return tree[node] = numbers[start];
		int mid = (start + end) / 2;
		return tree[node] = Math.max(segment(node * 2, start, mid), segment(node * 2 + 1, mid + 1, end));
	}

	private static int query(int left, int right, int node, int start, int end) {
		if (end < left || right < start) return Integer.MIN_VALUE;
		if (left <= start && right >= end) return tree[node];
		int mid = (start + end) / 2;
		return Math.max(query(left, right, node * 2, start, mid), query(left, right, node * 2 + 1, mid + 1, end));
	}

	private static int segment2(int node, int start, int end) {
		if (start == end) return tree2[node] = numbers[start];
		int mid = (start + end) / 2;
		return tree2[node] = Math.min(segment2(node * 2, start, mid), segment2(node * 2 + 1, mid + 1, end));
	}

	private static int query2(int left, int right, int node, int start, int end) {
		if (end < left || right < start) return Integer.MAX_VALUE;
		if (left <= start && right >= end) return tree2[node];
		int mid = (start + end) / 2;
		return Math.min(query2(left, right, node * 2, start, mid), query2(left, right, node * 2 + 1, mid + 1, end));
	}
}
