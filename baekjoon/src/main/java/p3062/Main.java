package p3062;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var t = sc.nextInt();
		var sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			var n = sc.next();
			var l = reverse(n.getBytes());
			var m = Integer.parseInt(n) + Integer.parseInt(l);
			if (is(String.valueOf(m))) {
				sb.append("YES");
			} else {
				sb.append("NO");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean is(String m) {
		var start = 0;
		var end = m.length() - 1;
		while (start < end) {
			if (m.charAt(start) != m.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	private static String reverse(byte[] bytes) {
		var result = new byte[bytes.length];
		for (int i = 0; i < bytes.length; i++) result[i] = bytes[bytes.length - i - 1];
		return new String(result);
	}
}
