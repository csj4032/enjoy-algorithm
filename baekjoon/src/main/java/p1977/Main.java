package baekjoon.p1977;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int sum = 0;
		int min = 10000;
		for (int i = M; i <= N; i++) {
			if (Math.sqrt((double) i) % 1 == 0) {
				sum = sum + i;
				if (min > i) min = i;
			}
		}

		if (sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}