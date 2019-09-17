package p2810;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		String s = sc.next();
		int k = 0;
		int t = 2;
		sb.append("*");
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			sb.append(c);
			if (c == 'L') {
				k++;
				if (k % 2 == 0 && i != n - 1) {
					sb.append("*");
					t++;
				}
			}
			if (c == 'S' && i != n - 1) {
				sb.append("*");
				t++;
			}
		}
		sb.append("*");
		System.out.println(n < t ? n : t);
	}
}
