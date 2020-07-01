package p18414;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var x = sc.nextInt();
		var l = sc.nextInt();
		var r = sc.nextInt();
		var m = Integer.MAX_VALUE;
		for (int i = l; i <= r; i++) m = Math.min(m, Math.abs(x - i));
		if (x < l) {
			System.out.println(l);
		} else if (x > r) {
			System.out.println(r);
		} else {
			System.out.println(x - m);
		}
	}
}
