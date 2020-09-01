package p17247;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var m = sc.nextInt();
		var p = new int[2][2];
		var t = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				var e = sc.nextInt();
				if (e == 1) {
					p[t][0] = i;
					p[t++][1] = j;
				}
			}
		}
		System.out.println(Math.abs(p[0][0] - p[1][0]) + Math.abs(p[0][1] - p[1][1]));
	}
}
