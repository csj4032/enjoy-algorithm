package p10175;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var sb = new StringBuilder();
		for (int i = 0; i < n; i++) sb.append(sc.next() + ": " + dominant(sc.next()) + "\n");
		System.out.println(sb.toString());
	}

	private static String dominant(String next) {
		int b = 0, c = 0, m = 0, w = 0;
		char[] chars = next.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == 'B') b += 2;
			if (chars[i] == 'C') c += 1;
			if (chars[i] == 'M') m += 4;
			if (chars[i] == 'W') w += 3;
		}

		int k = Math.max(Math.max(m, w), Math.max(b, c));
		int t = 0;

		String s = "";
		if (k == b) {
			t++;
			s = "The Bobcat is the dominant species";
		}

		if (k == c) {
			t++;
			s = "The Coyote is the dominant species";
		}

		if (k == m) {
			t++;
			s = "The Mountain Lion is the dominant species";
		}

		if (k == w) {
			t++;
			s = "The Wolf is the dominant species";
		}

		if (t > 1) {
			s = "There is no dominant species";
		}

		return s;
	}
}
