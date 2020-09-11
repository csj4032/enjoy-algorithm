package p15234;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var k = sc.nextInt();
		var m = 0;
		var l = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			l.add(sc.nextInt());
		}

		for (int i = 0; i < n; i++) {
			var t = k - l.get(i);
			if (l.contains(t)) {
				m++;
			}
		}

		System.out.println(m / 2);
	}
}
