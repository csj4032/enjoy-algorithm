package p2501;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var k = sc.nextInt();
		var t = 0;
		var i = 0;
		for (i = 1; i <= n; i++) {
			if (n % i == 0) t++;
			if (t == k) break;
		}
		if (t < k) {
			System.out.println("0");
		} else {
			System.out.println(i);
		}
	}
}
