package p13238;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var m = new long[n];
		var k = 0l;
		for (int i = 0; i < n; i++) {
			m[i] = sc.nextLong();
		}

		for (int i = 0; i < n; i++) {
			var t = m[i];
			for (int j = i + 1; j < n; j++) {
				k = Math.max(m[j] - t, k);
			}
		}

		System.out.println(k);
	}
}
