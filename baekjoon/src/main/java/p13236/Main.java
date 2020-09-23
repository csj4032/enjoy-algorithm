package p13236;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		while (true) {
			System.out.print(n + " ");
			if (n == 1) break;
			n = (n % 2 == 0) ? n / 2 : n * 3 + 1;
		}
	}
}
