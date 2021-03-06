package p4606;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			String str = sc.nextLine();
			if (str.equals("#")) {
				break;
			}
			System.out.println(escape(str));
		}
	}

	private static String escape(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == ' ') {
				sb.append("%20");
			} else if (c == '!') {
				sb.append("%21");
			} else if (c == '$') {
				sb.append("%24");
			} else if (c == '%') {
				sb.append("%25");
			} else if (c == '(') {
				sb.append("%28");
			} else if (c == ')') {
				sb.append("%29");
			} else if (c == '*') {
				sb.append("%2a");
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
}