package p5575;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 3; i++) {
			int h1 = sc.nextInt();
			int m1 = sc.nextInt();
			int s1 = sc.nextInt();

			int h2 = sc.nextInt();
			int m2 = sc.nextInt();
			int s2 = sc.nextInt();

			int s3;
			if (s2 < s1) {
				s3 = s2 + 60 - s1;
				m2 = m2 - 1;
			} else {
				s3 = s2 - s1;
			}

			int m3;
			if (m2 < m1) {
				m3 = m2 + 60 - m1;
				h2 = h2 - 1;
			} else {
				m3 = m2 - m1;
			}

			int h3 = h2 - h1;

			sb.append(h3).append(" ").append(m3).append(" ").append(s3).append("\n");
		}
		System.out.println(sb.toString());
	}
}
