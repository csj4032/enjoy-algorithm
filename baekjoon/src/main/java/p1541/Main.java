package p1541;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var w = sc.next();
		var t = 0l;
		if (w.contains("-")) {
			var s = w.split("-");
			for (int i = 0; i < s.length; i++) {
				var k = s[i].split("\\+");
				var p = 0l;
				for (int j = 0; j < k.length; j++) p += Long.parseLong(k[j]);
				if (i == 0) {
					t = t + p;
				} else {
					t = t - p;
				}
			}
		} else {
			var s = w.split("\\+");
			for (int i = 0; i < s.length; i++) t += Long.parseLong(s[i]);
		}
		System.out.println(t);
	}
}