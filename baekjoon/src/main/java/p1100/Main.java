package p1100;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] m = new String[8];
		int c = 0;

		for (int i = 0; i < 8; i++) {
			m[i] = sc.next();
		}

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				String s = m[i].substring(j, j + 1);
				if (s.equals("F") && ((i + j) & 1) == 0) {
					c++;
				}
			}
		}
		System.out.println(c);
	}
}