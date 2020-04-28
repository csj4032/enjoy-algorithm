package p14888;

import java.util.Scanner;

public class Main {

	static int[] numbers = new int[11];
	static int[] op = new int[10];
	static boolean[] v = new boolean[10];
	static int n = Integer.MIN_VALUE;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

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

		dfs(0, new int[n - 1]);
		System.out.println(max);
		System.out.println(min);
	}

	public static void dfs(int idx, int[] temp) {
		if (idx == n - 1) {
			int num = numbers[0];
			for (int i = 0; i < n - 1; i++) {
				if (temp[i] == 1) num = num + numbers[i + 1];
				if (temp[i] == 2) num = num - numbers[i + 1];
				if (temp[i] == 3) num = num * numbers[i + 1];
				if (temp[i] == 4) num = num / numbers[i + 1];
			}
			max = Math.max(num, max);
			min = Math.min(num, min);
			return;
		}
		for (int i = 0; i < n - 1; i++) {
			if (!v[i]) {
				v[i] = true;
				temp[idx] = op[i];
				dfs(idx + 1, temp);
				v[i] = false;
			}
		}
	}
}
