package p5565;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int k = 0;
		for (int i = 0; i < 9; i++) {
			k += sc.nextInt();
		}

		System.out.println(t - k);
	}
}
