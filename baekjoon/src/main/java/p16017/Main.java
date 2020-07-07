package p16017;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var a = sc.nextInt();
		var b = sc.nextInt();
		var c = sc.nextInt();
		var d = sc.nextInt();
		var k = false;
		if (a == 9 || a == 8) {
			if (b == c) {
				if (d == 9 || d == 8) {
					k = true;
				}
			}
		}
		System.out.println(k ? "ignore" : "answer");
	}
}
