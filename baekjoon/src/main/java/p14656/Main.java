package p14656;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = 0;

		for (int i = 1; i <= n; i++) {
			if (i != sc.nextInt()) {
				k++;
			}
		}

		System.out.println(k);
	}
}