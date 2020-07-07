package p16018;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var y = sc.next().split("");
		var t = sc.next().split("");
		var k = 0;
		for (int i = 0; i < n; i++) {
			if (y[i].equals("C") && t[i].equals("C")) {
				k++;
			}
		}
		System.out.println(k);
	}
}