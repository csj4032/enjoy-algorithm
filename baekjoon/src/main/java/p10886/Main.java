package p10886;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = 0;
		int b = 0;
		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			if (k == 0) {
				a++;
			} else {
				b++;
			}
		}

		if (a > b) {
			System.out.println("Junhee is not cute!");
		} else {
			System.out.println("Junhee is cute!");
		}
	}
}
