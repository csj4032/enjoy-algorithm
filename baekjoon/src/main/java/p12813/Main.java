package p12813;

import java.util.Scanner;

public class Main {

	static int l = 100000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();

		String[] aa = a.split("");
		String[] bb = b.split("");

		StringBuilder s1 = new StringBuilder();
		StringBuilder s2 = new StringBuilder();
		StringBuilder s3 = new StringBuilder();
		StringBuilder s4 = new StringBuilder();
		StringBuilder s5 = new StringBuilder();
		for (int i = 0; i < l; i++) {
			if (aa[i].equals("1") && bb[i].equals("1")) {
				s1.append("1");
			} else {
				s1.append("0");
			}

			if (aa[i].equals("1") || bb[i].equals("1")) {
				s2.append("1");
			} else {
				s2.append("0");
			}

			if (!aa[i].equals(bb[i])) {
				s3.append("1");
			} else {
				s3.append("0");
			}

			if (aa[i].equals("1")) {
				s4.append("0");
			} else {
				s4.append("1");
			}

			if (bb[i].equals("1")) {
				s5.append("0");
			} else {
				s5.append("1");
			}
		}

		System.out.println(s1.toString());
		System.out.println(s2.toString());
		System.out.println(s3.toString());
		System.out.println(s4.toString());
		System.out.println(s5.toString());
	}
}
