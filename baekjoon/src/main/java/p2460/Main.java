package p2460;

import java.util.Scanner;

// 지능형 기차 2
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int k = 0;
		for (int i = 0; i < 10; i++) {
			k = k - sc.nextInt();
			k = k + sc.nextInt();
			if (max < k) {
				max = k;
			}
		}

		System.out.println(max);
	}
}
