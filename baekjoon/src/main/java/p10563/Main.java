package p10563;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			var n = sc.nextInt();
			var m = new int[n + 2];
			for (int j = 1; j < n + 1; j++) {
				var nn = sc.nextInt();
				m[j] = nn;
			}

		}
	}
}