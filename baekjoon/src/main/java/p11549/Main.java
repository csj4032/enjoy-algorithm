package p11549;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var t = sc.nextInt();
		var k = 0;
		for (int i = 0; i < 5; i++) {
			var n = sc.nextInt();
			if (n == t) {
				k++;
			}
		}
		System.out.println(k);
	}
}
