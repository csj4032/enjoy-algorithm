package p5524;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			var m = sc.next();
			sb.append(m.toLowerCase() + "\n");
		}
		System.out.println(sb.toString());
	}
}
