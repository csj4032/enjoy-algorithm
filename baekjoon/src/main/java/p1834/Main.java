package p1834;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextLong();
		var m = n * n;
		var t = 0L;
		var s = n + 1;
		var k = s;
		var i = 2L;
		while (m > k) {
			t += k;
			k = s * i;
			i++;
		}
		System.out.println(t);
	}
}
