package p1075;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int f = sc.nextInt();
		n = n - n % 100;
		int i = 0;

		for (int j = 0; j < 100; j++) {
			if ((n + j) % f == 0) {
				break;
			}
			i++;
		}

		System.out.println(String.format("%02d", i));
	}
}
