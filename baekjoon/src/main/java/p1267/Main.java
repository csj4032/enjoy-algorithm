package p1267;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var m = 0;
		var y = 0;
		for (int i = 0; i < n; i++) {
			var t = sc.nextInt();
			y += mod(t, 30) * 10;
			m += mod(t, 60) * 15;
		}
		if (m == y) {
			System.out.println("Y M " + y);
		} else if (m < y) {
			System.out.println("M " + m);
		} else {
			System.out.println("Y " + y);
		}
	}

	private static int mod(int t, int k) {
		var s = 0;
		while (t > -1) {
			t = t - k;
			s++;
		}
		return s;
	}
}
