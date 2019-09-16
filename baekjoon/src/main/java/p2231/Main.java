package p2231;

import java.util.Scanner;

/**
 * 제목 : 분해합
 * 링크 : https://www.acmicpc.net/problem/2231
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = 0;
		for (int i = 1; i < n; i++) {
			if (n == getSum(i)) {
				k = i;
				break;
			}
		}
		System.out.print(k);
	}

	private static int getSum(int i) {
		int t = i;
		int s = i;
		while (t > 0) {
			s += t % 10;
			t = t / 10;
		}
		return s;
	}
}
