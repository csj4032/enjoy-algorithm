package p2991;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var a = sc.nextInt();
		var b = sc.nextInt();
		var c = sc.nextInt();
		var d = sc.nextInt();
		var p = sc.nextInt();
		var m = sc.nextInt();
		var n = sc.nextInt();
		var pp = 0;
		var mm = 0;
		var nn = 0;
		condition(a, b, c, d, p, pp);
		condition(a, b, c, d, m, mm);
		condition(a, b, c, d, n, nn);
	}

	private static void condition(int a, int b, int c, int d, int p, int pp) {
		if (0 < p % (a + b) && p % (a + b) <= a) pp++;
		if (0 < p % (c + d) && p % (c + d) <= c) pp++;
		System.out.println(pp);
	}
}
