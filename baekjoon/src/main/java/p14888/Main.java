package p14888;

import java.util.Scanner;

public class Main {

	static boolean[] visited = new boolean[10];
	static int[] numbers = new int[11];
	static int[] op = new int[10];
	static int n = Integer.MIN_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int idx = 0;

		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}

		for (int i = 0; i < 4; i++) {
			int cnt = sc.nextInt();
			for (int j = 0; j < cnt; j++) {
				op[idx++] = i + 1;
			}
		}

	}

	public static void dfs(int v, int idx, int num, int len) {

	}
}
