package p5585;

import java.util.Scanner;

public class Main {

	private static int[] COINS = new int[]{500, 100, 50, 10, 5, 1};
	private static int AMOUNT = 1000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int change = AMOUNT  - sc.nextInt();
		int count = 0, index = 0;

		while (change > 0) {
			if (change >= COINS[index]) {
				change -= COINS[index];
				count++;
			} else {
				index++;
			}
		}
		System.out.println(count);
	}
}