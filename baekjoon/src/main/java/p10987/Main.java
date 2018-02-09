package p10987;

import java.util.Scanner;

public class Main {

	static String[] chars = new String[]{"a", "e", "i", "o", "u"};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		String[] m = n.split("");
		int c = 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < 5; j++) {
				if(chars[j].equals(m[i])) {
					c++;
				}
			}
		}

		System.out.println(c);
	}
}