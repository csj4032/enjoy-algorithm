package p5766;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		while (true) {
			var n = sc.nextInt();
			var m = sc.nextInt();
			var l = new int[500];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					var k = sc.nextInt();
					l[k] += m - j;
				}
			}

			for (int i = 250000; i > 0; i--) {
				var t = false;
				for (int j = 0; j < 500; j++) {
					if (l[j] == i) {
						System.out.print(j);
						t = true;
					}
				}
				if (t) break;
			}
			System.out.println();
			//System.out.println(Arrays.toString(l));
			if (n == 0 && m == 0) break;
		}
	}
}
