package p12778;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static String[] alphabet = {"", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var t = sc.nextInt();
		var sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			var n = sc.nextInt();
			var m = sc.next();
			if (m.equals("C")) {
				for (int j = 0; j < n; j++) {
					var k = sc.next();
					sb.append(Arrays.binarySearch(alphabet, k) + " ");
				}
			} else {
				for (int j = 0; j < n; j++) {
					var k = sc.nextInt();
					sb.append(alphabet[k] + " ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}