package p9086;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			String s = sc.next();
			int len = s.length();
			System.out.println(s.substring(0, 1) + "" + s.substring(len-1, len));
		}
	}
}
