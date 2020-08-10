package p2567;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var mm = new boolean[100][100];
		for (int i = 0; i < n; i++) {
			var x = sc.nextInt();
			var y = sc.nextInt();
			for (int j = y; j < y + 10; j++) {
				for (int k = x; k < x + 10; k++) {
					mm[j][k] = true;
				}
			}
		}
		var k = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (mm[i][j]) k++;
			}
		}
		System.out.println(k);
	}
}
