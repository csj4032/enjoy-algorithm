package p10984;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int k = 0;
			double g = 0d;
			for (int j = 0; j < n; j++) {
				int c = sc.nextInt();
				k += c;
				g += (sc.nextDouble() * c);
			}
			g = g / k;
			sb.append(k).append(" ").append(String.format("%.1f", g)).append("\n");
		}
		System.out.println(sb.toString());
	}
}
