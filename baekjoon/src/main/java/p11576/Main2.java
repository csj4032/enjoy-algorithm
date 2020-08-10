package p11576;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var a = sc.nextInt();
		var b = sc.nextInt();
		var m = sc.nextInt();
		var k = 0;
		for (int i = 0; i < m; i++) {
			k = k * a + sc.nextInt();
		}
		recursive(k, b);
	}

	private static void recursive(int k, int b) {
		if (k == 0) return;
		recursive(k / b, b);
		System.out.print(k % b + " ");
	}
}