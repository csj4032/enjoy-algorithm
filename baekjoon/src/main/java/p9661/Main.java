package p9661;

import java.util.Scanner;

// Baekjoon Online Judge : 돌 게임 7
public class Main {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		long n = sc.nextLong();
//		if (n % 5 == 0 || n % 5 == 2) {
//			System.out.println("CY");
//		} else {
//			System.out.println("SK");
//		}

		label:
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.println("[" + i + " ," + j + "]");
				if (i % 2 == 0 && j % 2 == 0) {
					break label;
				}
			}
		}
	}
}
