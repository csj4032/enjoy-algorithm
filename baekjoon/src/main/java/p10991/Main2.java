package p10991;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int start = n - 1;
		int end = n;
		for (int i = 0; i < n; i++) {
			int d = 0;
			for (int j = 0; j < end; j++) {
				if (j == start + (2 * d)) {
					sb.append("*");
					d++;
				} else {
					sb.append(" ");
				}
			}
			start--;
			end++;
			sb.append("\n");
		}
		System.out.println(sb);
	}
}