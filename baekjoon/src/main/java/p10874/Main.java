package p10874;

import java.util.Scanner;

/**
 * 제목 : 이교수님의 시험
 * 링크 : https://www.acmicpc.net/problem/10874
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();

		int[][] m = new int[n][10];
		int[] l = new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5};

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 10; j++) {
				m[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			boolean flag = true;
			for (int j = 0; j < 10; j++) {
				if (m[i][j] != l[j]) {
					flag = false;
					break;
				}
			}
			if(flag) sb.append((i+1) + "\n");
		}

		System.out.println(sb.toString());
	}
}
