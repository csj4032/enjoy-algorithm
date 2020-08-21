package p15780;

import java.util.Scanner;

public class Main {

	private static int[] map = {0, 1, 1, 2, 2, 3, 3, 4, 4};

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var k = sc.nextInt();
		var t = 0;
		for (int i = 0; i < k; i++) {
			var m = sc.nextInt();
			t += map[m];
		}
		if (t >= n) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
