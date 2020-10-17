package p14914;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var a = sc.nextInt();
		var b = sc.nextInt();
		var c = Math.min(a, b);
		var sb = new StringBuilder();
		for (int i = 1; i <= c; i++) {
			if (a % i == 0 && b % i == 0) sb.append(i + " " + a / i + " " + b / i + "\n");
		}
		System.out.println(sb.toString());
	}
}
