package p5544;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var l = n * (n - 1) / 2;
		var m = new int[n];

		for (int i = 0; i < l; i++) {
			var a = sc.nextInt();
			var b = sc.nextInt();
			var c = sc.nextInt();
			var d = sc.nextInt();

			if (c > d) {
				m[a - 1] += 3;
			}
			if (c == d) {
				m[a - 1] += 1;
				m[b - 1] += 1;
			}
			if (c < d) {
				m[b - 1] += 3;
			}
		}

		//System.out.println(Arrays.toString(m));

		for (int i = 0; i < n; i++) {
			var r = 1;
			for (int j = 0; j < n; j++) {
				if (i == j) continue;
				if (m[i] < m[j]) r++;
			}
			System.out.println(r);
		}
	}
}
