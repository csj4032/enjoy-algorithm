package p15667;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var k = 0;
		for (int i = 0; i <= n; i++) {
			var t = (i * i) + (i) + 1;
			if (n == t) {
				k = i;
				break;
			}
		}
		System.out.println(k);
	}
}
