package p2525;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var h = sc.nextInt();
		var m = sc.nextInt();
		var e = sc.nextInt();
		var h2 = (m + e) / 60;
		m = (m + e) % 60;
		h = (h2 + h) % 24;
		System.out.println(h + " " + m);
	}
}
