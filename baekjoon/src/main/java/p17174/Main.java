package p17174;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var m = sc.nextInt();
		var t = n % m;
		var k = (n / m) * m;
		var g = 0;
		while (n > 1) {
			n = n / m;
			g += n;
		}
		System.out.println(t + k + g);
	}
}
