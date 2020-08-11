package p15813;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var m = sc.next();
		var k = 0;
		for (int i = 0; i < n; i++) {
			k += m.charAt(i) - 64;
		}
		System.out.println(k);
	}
}
