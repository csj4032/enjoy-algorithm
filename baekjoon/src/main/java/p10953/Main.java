package p10953;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			String[] s = sc.next().split(",");
			int a = Integer.valueOf(s[0]);
			int b = Integer.valueOf(s[1]);
			System.out.printf("%d\n", (a+b));
		}
	}
}