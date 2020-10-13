package p18429;

import java.util.Scanner;

/**
 * 제목 : 근손실
 * 링크 : https://www.acmicpc.net/problem/18429
 * 분류 : 브루트포스 알고리즘, 백트래킹
 */
public class Main {

	static int n;
	static int k;
	static int p;
	static int[] numbers;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}
		permutation(0);
		System.out.println(p);
	}

	private static void permutation(int depth) {
		if (depth == n) {
			var flag = true;
			var tt = 500;
			for (int i = 0; i < n; i++) {
				tt = tt - k + numbers[i];
				if (tt < 500) {
					flag = false;
					break;
				}
			}
			if (flag) p++;
			return;
		}
		for (int i = depth; i < n; i++) {
			swap(i, depth);
			permutation(depth + 1);
			swap(i, depth);
		}
	}

	private static void swap(int p, int q) {
		int t = numbers[p];
		numbers[p] = numbers[q];
		numbers[q] = t;
	}
}
