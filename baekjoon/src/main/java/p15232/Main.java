package p15232;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var sb = new StringBuilder();
		var r = sc.nextInt();
		var c = sc.nextInt();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
