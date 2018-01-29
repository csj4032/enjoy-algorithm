package p3460;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			String binary = new StringBuilder(Integer.toBinaryString(sc.nextInt())).reverse().toString();
			char[] chars = binary.toCharArray();
			int k = 0;
			StringBuilder sb = new StringBuilder();
			for (char c : chars) {
				if (c == '1') {
					sb.append(k + " ");
				}
				k++;
			}

			sb.deleteCharAt(sb.length() - 1);
			System.out.println(sb.toString());
		}
	}
}