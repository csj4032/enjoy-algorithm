package p1526;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = n; i >= 4; i--) {
			if (isSevenAndFour(i)) {
				System.out.println(i);
				break;
			}
		}
	}

	private static boolean isSevenAndFour(int n) {
		boolean flag = true;
		while (n > 0) {
			int k = n % 10;
			if (k == 4 || k == 7) {
				n = n / 10;
			} else {
				flag = false;
				break;
			}
		}
		return flag;
	}
}
