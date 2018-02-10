package p10974;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		//for (int i = 0; i < n; i++) {
			recursive(0, n);
		//}
	}

	private static void recursive(int k, int n) {
		if (n <= 0) return;
		System.out.print(k);
		recursive(k + 1, n - 1);
		System.out.print(k);
		recursive(k + 1, n - 1);
		System.out.println();
	}
}