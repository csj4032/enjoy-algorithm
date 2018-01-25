package p2789;

import java.util.Scanner;

public class Main {

	static String m = "CAMBRIDGE";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		String l = "";

		for (int i = 0; i < n.length(); i++) {
			String k = n.substring(i, i + 1);
			if (m.indexOf(k) == -1) {
				l += k;
			}
		}

		System.out.println(l);
	}
}